# Connect Four AI — CS1360 Project

A Python-based **Connect Four** game featuring two artificial intelligence agents: **Minimax with Alpha–Beta Pruning** and **Monte Carlo Tree Search (MCTS)**. The project includes Human vs AI and AI vs AI gameplay modes, along with experiments to compare algorithm performance.

> **Status:** In development. This README describes the intended project structure and commands; update it as implementation is completed.

## Project Information

| Item | Details |
| --- | --- |
| University | Imam Mohammad Ibn Saud Islamic University |
| College | College of Computer and Information Sciences |
| Course | Artificial Intelligence (CS1360) |
| Project | Connect Four AI |
| Language | Python |
| Deadline | December 5, 2026, at 11:59 PM |

## Objectives

- Implement a playable **6 × 7** Connect Four game.
- Support **Human vs AI** and **AI vs AI** modes.
- Implement depth-limited Minimax with **Alpha–Beta Pruning**.
- Implement **Monte Carlo Tree Search (MCTS)**.
- Compare performance through experiments and visualizations.

## Game Rules

Two players alternate dropping discs into one of seven columns. Each disc occupies the lowest available cell. **Yellow is MAX** and **Red is MIN**. The first player to connect four discs horizontally, vertically, or diagonally wins. If the board fills without a winner, the game is a draw.

## Algorithms and Configurations

| Algorithm | Required configurations |
| --- | --- |
| Minimax + Alpha–Beta Pruning | Search depths `k = 2, 6, 10` |
| Monte Carlo Tree Search | Simulation counts `s = 100, 1000, 2000` |

Alpha–Beta uses a **heuristic evaluation function** at non-terminal depth cutoffs. MCTS selects moves based on simulated game outcomes.

## Required Experiments

1. **Alpha–Beta vs Alpha–Beta** — compare different search depths.
2. **MCTS vs MCTS** — compare different simulation counts.
3. **Best Alpha–Beta vs Best MCTS** — compare the strongest selected configurations.

Record execution times and gameplay behavior, and present findings using tables and graphs. **Each game must finish within 30 minutes.**

## Planned Project Structure

```text
Connect-Four-AI/
├── game.py             # Board, legal moves, rules, and Human vs AI support
├── alpha_beta.py       # Depth-limited Minimax with Alpha–Beta pruning
├── mcts.py             # Monte Carlo Tree Search agent
├── experiments.py      # AI vs AI experiments, metrics, and plots
├── main.py             # Program entry point and mode selection
├── requirements.txt    # Python dependencies
├── README.md           # Project documentation
└── results/            # Generated tables and figures
```

**Shared interface (agree on this before implementing):**

```python
get_valid_moves(board)
make_move(board, column, player)
check_winner(board, player)
```

The team should standardize board representation, player values, and agent input/output before integrating their files.

## Installation

**Prerequisite:** Python 3.10 or newer.

```bash
git clone <YOUR-REPOSITORY-URL>
cd Connect-Four-AI
python -m pip install -r requirements.txt
```

Replace `<YOUR-REPOSITORY-URL>` with your GitHub repository URL.

## Run the Program

Once the files and entry points have been implemented:

```bash
python main.py
```

Choose **Human vs AI** or **AI vs AI** from the program menu.

To run the experiments (after the experiments script is implemented):

```bash
python experiments.py
```

> The commands above describe the **planned** entry points; they will work only after their respective Python files are written.

## Team Responsibilities

| Member | Main responsibility |
| --- | --- |
| Member 1 | Game engine, rules, and Human vs AI mode |
| Member 2 | Alpha–Beta agent, heuristic, and depth configurations |
| Member 3 | MCTS agent and simulation configurations |
| Member 4 | AI vs AI integration, experiments, and result plots |

All members contribute to the written report, testing, presentation, and final review.

## Deliverables

- **PDF report** in English: introduction, game representation and design, implemented algorithms, experimental results, analysis, and conclusion.
- **ZIP archive** containing the source code.
- **PowerPoint presentation** and a live program demonstration.

Only **one group member** submits the final deliverables through Blackboard.


*Developed for the CS1360 Artificial Intelligence course at Imam Mohammad Ibn Saud Islamic University.*
