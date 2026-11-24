<div align="center">

# 🎮 CONNECT FOUR AI

### CS1360 · Artificial Intelligence · Term Project

**Exploring intelligent decision-making through Alpha–Beta Pruning and Monte Carlo Tree Search.**

<p>
  <img alt="Course: CS1360" src="https://img.shields.io/badge/COURSE-CS1360-475569?style=for-the-badge" />
  <img alt="Language: Java" src="https://img.shields.io/badge/JAVA-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img alt="Project status: In development" src="https://img.shields.io/badge/STATUS-IN%20DEVELOPMENT-F59E0B?style=for-the-badge" />
</p>

<p>
  <img alt="Algorithm: Alpha Beta" src="https://img.shields.io/badge/AI-ALPHA--BETA-6366F1?style=flat-square" />
  <img alt="Algorithm: MCTS" src="https://img.shields.io/badge/AI-MCTS-0D9488?style=flat-square" />
  <img alt="Board size: 6 by 7" src="https://img.shields.io/badge/BOARD-6%20%C3%97%207-64748B?style=flat-square" />
</p>

**Imam Mohammad Ibn Saud Islamic University**  
College of Computer and Information Sciences · Computer Science Department

</div>

---

> [!NOTE]
> **Status: In development.** This README describes the required features and intended project structure. No implementation or experimental results are claimed to be complete.

## 📌 Project Overview

**Connect Four AI** is a Java-based academic project focused on comparing two intelligent game-playing approaches in a classic two-player strategy game:

- **Minimax with Alpha–Beta Pruning** and depth-limited search.
- **Monte Carlo Tree Search (MCTS)** using repeated simulations.

The completed system will support **Human vs AI** and **AI vs AI** gameplay and compare performance across the required settings.

| Project detail | Information |
|:--|:--|
| **Course** | Artificial Intelligence (`CS1360`) |
| **Language** | Java |
| **Development environment** | Visual Studio Code |
| **Board** | 6 rows × 7 columns |
| **Algorithms** | Alpha–Beta Pruning and MCTS |
| **Deadline** | **December 5, 2026 · 11:59 PM** |
| **Project discussions** | December 6–10, 2026 |

## 🎯 Project Objectives

| Component | Requirements |
|:--|:--|
| **Game representation** | Define the board state, legal moves, terminal conditions, and evaluation function |
| **Game mechanics** | Initialize/display the board, drop pieces, and detect wins or draws |
| **Alpha–Beta** | Implement depth-limited Minimax with Alpha–Beta pruning and heuristic evaluation |
| **MCTS** | Implement Monte Carlo Tree Search with adjustable simulation counts |
| **Game modes** | Support Human vs AI and AI vs AI |
| **Testing** | Compare execution time and gameplay behavior using the specified experiments |

## 🟡 Connect Four Rules

Players take turns dropping a piece into one of seven columns. Each piece lands in the lowest available cell.

| Player | Color | Search role |
|:--|:--:|:--:|
| Player 1 | 🟡 Yellow | MAX |
| Player 2 | 🔴 Red | MIN |

A player wins by placing **four pieces in a row**, horizontally, vertically, or diagonally. A full board without a winner is a **draw**.

<details>
<summary><b>Illustrative game board</b></summary>

```text
      1  2  3  4  5  6  7
    +---------------------+
  1 | .  .  .  .  .  .  . |
  2 | .  .  .  .  .  .  . |
  3 | .  .  .  .  .  .  . |
  4 | .  .  .  .  .  .  . |
  5 | .  .  .  R  .  .  . |
  6 | .  Y  Y  Y  Y  R  . |
    +---------------------+

    Y = Yellow   R = Red   . = Empty
```

In this example, Yellow has four connected pieces horizontally.

</details>

## 🧠 AI Algorithms

### 01 · Depth-Limited Minimax with Alpha–Beta Pruning

The Alpha–Beta agent searches possible future game states and prunes branches that cannot influence the final choice. A **heuristic evaluation function** scores non-terminal states at the depth cutoff.

| Configuration | Required values |
|:--|:--|
| Search depth (`k`) | `2`, `6`, `10` |
| Search strategy | Depth-limited Minimax |
| Optimization | Alpha–Beta Pruning |
| Cutoff scoring | Heuristic Evaluation Function |

### 02 · Monte Carlo Tree Search (MCTS)

The MCTS agent selects moves based on simulated play. Its main stages are **selection, expansion, simulation, and backpropagation**.

| Configuration | Required values |
|:--|:--|
| Number of simulations (`s`) | `100`, `1000`, `2000` |
| Search strategy | Monte Carlo Tree Search |

## 📊 Required Experiments

| Experiment | Matchup | Purpose |
|:--:|:--|:--|
| **01** | Alpha–Beta vs Alpha–Beta | Compare depth configurations |
| **02** | MCTS vs MCTS | Compare simulation configurations |
| **03** | Best Alpha–Beta vs Best MCTS | Compare selected best-performing configurations |

Experiments will consider **execution time** and **gameplay behavior**. The assignment specifies a maximum of **30 minutes per game**. Actual results, charts, and discussion will be included after implementation and testing.

## 🗂️ Project Structure

```text
Connect-Four-AI/
├── src/
│   ├── ConnectFourGame.java   # Game state and rules
│   ├── AlphaBetaAI.java       # Alpha–Beta agent
│   ├── MCTSAI.java            # MCTS agent
│   ├── Experiments.java      # AI vs AI evaluation
│   └── Main.java             # Program entry point
└── README.md                 # Project documentation
```

> The Java source files are **empty placeholders at this stage**. The structure may be refined as the team develops the project.

## ⚙️ Development Setup

**Planned tools:** Java JDK 21, Visual Studio Code with the Extension Pack for Java, Git, and GitHub. All contributors should use a compatible Java version.

1. Clone the repository to your computer.
2. Open the project folder in Visual Studio Code.
3. Implement the assigned Java classes in `src/`.
4. Agree on shared board representation, public methods, and agent interfaces before connecting the classes.
5. Run and test the completed application and record the experiments.

> Run commands will be documented after the entry point and build configuration have been finalized.

## 🤝 Collaboration

The project is organized into these development areas:

| Workstream | Main responsibilities |
|:--|:--|
| **Game mechanics & integration** | Shared game state, legal moves, victory/draw detection, and AI vs AI integration |
| **Alpha–Beta implementation** | Agent logic, heuristic evaluation, and depth-related experiments |
| **MCTS implementation** | Agent logic, simulation configurations, and related experiments |

Contributors develop separate Java classes and use GitHub branches/pull requests to integrate changes. **Testing, written report, and live presentation** are shared responsibilities.

## 📦 Submission Deliverables

- [ ] **English PDF report:** introduction, game representation, algorithms, experiments, results, discussion, and conclusion.
- [ ] **ZIP archive:** Java source files.
- [ ] **PowerPoint:** project presentation.
- [ ] **Live demo:** demonstration of the working program during the discussion.

One group member submits the required files through **Blackboard**.

## 👩‍💻 Authors

- **Sadeem Alnahdi** — سديم النهدي
- **Ghada Alomar** — غاده العمر
- **Aryam Alshahri** — اريام الشهري



## © Copyright & Academic License

The following notice follows the **course-specific copyright text provided in the CS1360 project instructions**, with the year and author names filled in. It is **not a general-purpose open-source license**.

> **Copyright (CC) 2026 Sadeem Alnahdi, Ghada Alomar, Aryam Alshahri, **
>
> This software was developed as part of a project for CS1360 course at Imam Mohammad ibn Saud Islamic University.
>
> Permission is granted to use, copy, and modify this software for educational and non-commercial research purposes only, provided that proper attribution is given to the authors and the university.
>
> Commercial use, sublicensing, or redistribution for profit is prohibited without prior written approval from Imam Mohammad ibn Saud Islamic University.
>
> This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
>

> [!IMPORTANT]
> The project instructions request that this copyright notice also be **added to the code when publishing the project online**. The current Java files are intentionally empty; the notice can be inserted when source development begins.

---

<div align="center">
  <sub>Academic project · CS1360 · Imam Mohammad Ibn Saud Islamic University · © 2026</sub>
</div>
