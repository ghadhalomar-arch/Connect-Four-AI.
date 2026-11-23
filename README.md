<div align="center">

# 🎮 CONNECT FOUR AI

### Intelligent Game-Playing Agents · CS1360

**A Connect Four project exploring decision-making with Alpha–Beta Pruning and Monte Carlo Tree Search.**

<p>
  <img alt="Course: CS1360" src="https://img.shields.io/badge/COURSE-CS1360-475569?style=for-the-badge" />
  <img alt="Language: Python" src="https://img.shields.io/badge/PYTHON-3776AB?style=for-the-badge&logo=python&logoColor=white" />
  <img alt="Project status: In development" src="https://img.shields.io/badge/STATUS-IN%20DEVELOPMENT-F59E0B?style=for-the-badge" />
</p>

<p>
  <img alt="Algorithm: Alpha Beta" src="https://img.shields.io/badge/AI-ALPHA--BETA-6366F1?style=flat-square" />
  <img alt="Algorithm: MCTS" src="https://img.shields.io/badge/AI-MCTS-0D9488?style=flat-square" />
  <img alt="Board size: 6 by 7" src="https://img.shields.io/badge/BOARD-6%20%C3%97%207-64748B?style=flat-square" />
</p>

*Imam Mohammad Ibn Saud Islamic University · College of Computer and Information Sciences*

</div>

---

> [!NOTE]
> **Project status: In development.** This README documents the requirements and planned implementation. Features, scripts, and results will be updated as they are completed.

## 📌 Overview

**Connect Four AI** is a two-player strategy game built to study how different artificial intelligence search approaches make decisions. The project will implement a standard **6 × 7 Connect Four** game and compare two agents:

- **Minimax with Alpha–Beta Pruning** and depth-limited search.
- **Monte Carlo Tree Search (MCTS)** using simulated game outcomes.

The system is designed to support both **Human vs AI** and **AI vs AI**, allowing a structured comparison of move selection and execution time.

### Project at a glance

| | Details |
|:--|:--|
| **Course** | Artificial Intelligence — `CS1360` |
| **Project type** | Team term project (3–4 students) |
| **Language** | Python (planned; Java is also permitted) |
| **Game** | Connect Four · 6 rows × 7 columns |
| **Agents** | Alpha–Beta Pruning · MCTS |
| **Deadline** | **December 5, 2026 · 11:59 PM** |
| **Demonstrations** | December 6–10, 2026 |

## 🎯 Project Objectives

| Component | Requirement |
|:--|:--|
| **Game Engine** | Initialize and display the board, generate legal moves, place discs, and detect wins/draws |
| **Alpha–Beta Agent** | Implement depth-limited Minimax with Alpha–Beta pruning and a heuristic evaluation function |
| **MCTS Agent** | Implement Monte Carlo Tree Search with configurable simulation counts |
| **Game Modes** | Support Human vs AI and AI vs AI |
| **Evaluation** | Compare agent behavior and execution time across the required experiments |

## 🟡 Game Rules

Players take turns dropping discs into one of **seven columns**. A disc occupies the **lowest available cell** in its selected column.

| Player | Color | Search role |
|:--|:--:|:--:|
| Player 1 | 🟡 Yellow | **MAX** |
| Player 2 | 🔴 Red | **MIN** |

A player wins by connecting **four discs** horizontally, vertically, or diagonally. If the board becomes full without a winner, the game ends in a **draw**.

<details>
<summary><b>Example board (illustrative)</b></summary>

```text
      1  2  3  4  5  6  7
    ┌─────────────────────┐
  1 │ ·  ·  ·  ·  ·  ·  · │
  2 │ ·  ·  ·  ·  ·  ·  · │
  3 │ ·  ·  ·  ·  ·  ·  · │
  4 │ ·  ·  ·  ·  ·  ·  · │
  5 │ ·  ·  ·  R  ·  ·  · │
  6 │ ·  Y  Y  Y  Y  R  · │
    └─────────────────────┘

    Y = Yellow    R = Red    · = Empty
```

In this example, Yellow has connected four discs horizontally.

</details>

## 🧠 AI Algorithms

### 01 · Minimax with Alpha–Beta Pruning

Alpha–Beta searches possible future moves while pruning branches that cannot change the selected decision. A **heuristic evaluation function** estimates non-terminal board positions when the search reaches its depth limit.

| Parameter | Required values |
|:--|:--|
| Search depth (`k`) | `2` · `6` · `10` |
| Search approach | Depth-limited Minimax |
| Optimization | Alpha–Beta Pruning |
| Cutoff handling | Heuristic board evaluation |

### 02 · Monte Carlo Tree Search (MCTS)

MCTS estimates promising moves through repeated simulations. Its main stages are **selection, expansion, simulation, and backpropagation**.

| Parameter | Required values |
|:--|:--|
| Simulations (`s`) | `100` · `1000` · `2000` |
| Search approach | Monte Carlo Tree Search |
| Decision basis | Outcomes of simulated play |

## 📊 Required Experiments

The project compares the agents in **AI vs AI** mode using three experimental matchups:

| Experiment | Matchup | Goal |
|:--:|:--|:--|
| **01** | Alpha–Beta **vs** Alpha–Beta | Compare different search depths |
| **02** | MCTS **vs** MCTS | Compare different simulation counts |
| **03** | Best Alpha–Beta **vs** Best MCTS | Compare the best selected configurations |

**Evaluation focus:** execution time, gameplay behavior, and differences across configurations.

> [!IMPORTANT]
> The maximum allowed execution time is **30 minutes per game**. Results will be documented using tables, graphs, and analysis in the final report.

## 🗂️ Planned Project Structure

```text
Connect-Four-AI/
│
├── game.py             # Board, legal moves, win/draw detection
├── alpha_beta.py       # Depth-limited Minimax + Alpha–Beta
├── mcts.py             # Monte Carlo Tree Search
├── experiments.py      # AI vs AI tests and result collection
├── main.py             # Program entry point / game modes
│
├── results/            # Experiment tables and figures
├── requirements.txt    # Python dependencies
└── README.md           # Project documentation
```

> The file structure is **proposed** and may be refined during development.

### Shared interface (team convention)

To simplify integration, each agent should use the same game representation and move format. The team can agree on helper functions such as:

```python
get_valid_moves(board)
make_move(board, column, player)
check_winner(board, player)
```

These are **suggested interface names**, not completed functions.

## ⚙️ Getting Started

**Prerequisite:** Python 3.10+ (recommended).

**1. Clone the repository**

```bash
git clone <YOUR-REPOSITORY-URL>
cd Connect-Four-AI
```

**2. Install dependencies**

```bash
python -m pip install -r requirements.txt
```

**3. Launch the game** *(after implementation)*

```bash
python main.py
```

**4. Run experiments** *(after implementation)*

```bash
python experiments.py
```

> [!WARNING]
> `main.py` and `experiments.py` are **planned entry points**. The run commands are provided as a template until those scripts are implemented.

## 👩‍💻 Team Responsibilities

| Member | Development area | Documentation contribution |
|:--:|:--|:--|
| **01** | Game engine and Human vs AI mode | Introduction and game representation |
| **02** | Alpha–Beta agent and heuristic evaluation | Alpha–Beta design and depth configurations |
| **03** | MCTS agent and simulations | MCTS design and simulation configurations |
| **04** | AI vs AI integration and experimental evaluation | Results, charts, and discussion |

**Shared responsibilities:** integration testing, report review, presentation preparation, and live demonstration. This is a **proposed team allocation**, not a course-mandated division.

## 📦 Deliverables

- [ ] **PDF report (English)** — introduction, game design, algorithms, experimental results, analysis, and conclusion.
- [ ] **ZIP archive** — source code files.
- [ ] **PowerPoint presentation** — summary of the project and findings.
- [ ] **Live demonstration** — functioning program shown during the project discussion.

Only **one team member** should submit the final files through **Blackboard**.

## 📄 Academic Use & Attribution

This project is developed for the **CS1360 Artificial Intelligence** course at **Imam Mohammad Ibn Saud Islamic University**.

The official assignment includes a **course-specific copyright notice** to add to source code if the project is published online. Refer to the assignment for the complete required wording and attribution conditions. Do not assume an open-source license has been granted.

---

<div align="center">
  <sub>Built for learning, experimentation, and intelligent decision-making.</sub>
</div>
