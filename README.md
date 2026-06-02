<div align="center">

```
███████╗████████╗██╗   ██╗██████╗ ██╗   ██╗    ████████╗██╗███╗   ███╗███████╗██████╗
██╔════╝╚══██╔══╝██║   ██║██╔══██╗╚██╗ ██╔╝    ╚══██╔══╝██║████╗ ████║██╔════╝██╔══██╗
███████╗   ██║   ██║   ██║██║  ██║ ╚████╔╝        ██║   ██║██╔████╔██║█████╗  ██████╔╝
╚════██║   ██║   ██║   ██║██║  ██║  ╚██╔╝         ██║   ██║██║╚██╔╝██║██╔══╝  ██╔══██╗
███████║   ██║   ╚██████╔╝██████╔╝   ██║          ██║   ██║██║ ╚═╝ ██║███████╗██║  ██║
╚══════╝   ╚═╝    ╚═════╝ ╚═════╝    ╚═╝          ╚═╝   ╚═╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝
```

### ⚡ A game-inspired focus & productivity timer — built with Java + Swing

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/UI-Swing-5C6BC0?style=for-the-badge&logo=java&logoColor=white)
![Gson](https://img.shields.io/badge/Data-Gson%20JSON-4DB6AC?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-78909C?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-66BB6A?style=for-the-badge)

</div>

---

## ✨ What is StudyTimer?

**StudyTimer** is a standalone desktop productivity app wrapped in a dark, game-like aesthetic. It's not just a timer — it's a full focus system with XP tracking, streaks, deep statistics, and an auto-cycling Pomodoro engine. No bloat, no subscriptions, no cloud. Just you, your sessions, and your data stored locally.

> _"Level up your focus. One session at a time."_

---

## 🗂️ Table of Contents

- [Features](#-features)
- [Screenshots](#-screenshots)
- [Getting Started](#-getting-started)
- [How It Works](#-how-it-works)
- [Project Structure](#-project-structure)
- [Data & Storage](#-data--storage)
- [Building from Source](#-building-from-source)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🚀 Features

### 🎯 Timer Tab
- **Focus Timer** (blue arc) and **Break Timer** (green arc) displayed as a single animated arc
- Smooth **mode toggle** between Focus and Break
- **Auto-Start Mode** — seamlessly cycles Focus → Break → Focus automatically
- **Manual Mode** — each timer stops and waits for your command
- Programmatically generated **sound chime** on completion (no external audio files required)
- **Popup dialog** notification when a session ends
- Only **Focus sessions** are recorded to your stats

### ⏱️ Stopwatch Tab
- Precision display: `HH:MM:SS.cc`
- Full controls: **Start / Pause / Reset / Lap**
- Lap history displayed inline

### 📊 Statistics Tab _(Game-Like)_
- **Level + XP System** — total focus minutes = XP; level up every X hours
- **Streak Tracker** — consecutive days with at least one focus session
- **Daily Graph** — 6 bars mapped to 4-hour time-of-day chunks:
  - 🌙 Midnight · 🌅 Morning · ☀️ Afternoon · 🌆 Evening · 🌃 Night · 🌚 Late
- **Weekly Graph** — Mon–Sun bar chart
- **Monthly Graph** — day-by-day breakdown
- All graphs use **gradient bars with glow effects**, rendered via custom `Graphics2D`

### ⚙️ Settings Tab
- Spinners for **Focus duration** and **Break duration**
- **Daily goal** configuration
- **Auto-start toggle**
- **Save button** — persists all settings to disk

---

## 📸 Screenshots

> _Add your screenshots here_

| Timer — Focus Mode | Statistics — Weekly View | Settings |
|---|---|---|
| `screenshot_timer.png` | `screenshot_stats.png` | `screenshot_settings.png` |

---

## 🏁 Getting Started

### Prerequisites

- Java **17** or higher installed
- No other dependencies needed at runtime

### Run the Jar

```bash
# Download the latest release
java -jar StudyTimer.jar
```

That's it. No installation, no setup wizard.

---

## ⚙️ How It Works

### Focus / Break Cycle

```
[Focus Timer]  ──── ends ────▶  [Break Timer]  ──── ends ────▶  [Focus Timer]  ──▶ ...
      ▲                                                                  │
      │                         (Auto-Start ON)                         │
      └─────────────────────────────────────────────────────────────────┘

      If Auto-Start is OFF → timer halts and waits for manual start
```

### XP & Leveling

```
Total Focus Minutes  =  XP
Every N hours        =  +1 Level
Streak               =  Consecutive days with ≥ 1 focus session
```

### Time-of-Day Buckets (Daily Graph)

| Bar | Label | Time Range |
|-----|-------|------------|
| 1 | 🌙 Midnight | 00:00 – 04:00 |
| 2 | 🌅 Morning | 04:00 – 08:00 |
| 3 | ☀️ Afternoon | 08:00 – 12:00 |
| 4 | 🌆 Evening | 12:00 – 16:00 |
| 5 | 🌃 Night | 16:00 – 20:00 |
| 6 | 🌚 Late | 20:00 – 24:00 |

---

## 🗃️ Project Structure

```
StudyTimer/
├── src/
│   └── com/studytimer/
│       ├── Main.java                  # Entry point
│       ├── ui/
│       │   ├── MainFrame.java         # Root JFrame + tab layout
│       │   ├── TimerPanel.java        # Focus/Break arc timer
│       │   ├── StopwatchPanel.java    # Stopwatch tab
│       │   ├── StatsPanel.java        # Statistics + graphs
│       │   └── SettingsPanel.java     # Settings tab
│       ├── timer/
│       │   ├── FocusTimer.java        # Timer logic + auto-start
│       │   └── SoundEngine.java       # Programmatic chime generation
│       ├── stats/
│       │   ├── SessionRecord.java     # Single session model
│       │   ├── StatsEngine.java       # XP, level, streak computation
│       │   └── GraphRenderer.java     # Graphics2D gradient bar charts
│       └── data/
│           ├── DataManager.java       # Read/write JSON via Gson
│           └── AppSettings.java       # Settings model
├── data/                              # Bundled defaults (if any)
├── StudyTimer.jar                     # Runnable artifact
└── README.md
```

---

## 💾 Data & Storage

All data is saved locally — no network access, ever.

```
~/.studytimer/
├── sessions.json      # All recorded focus sessions
└── settings.json      # User preferences (durations, goal, etc.)
```

Data format (sessions):

```json
[
  {
    "date": "2025-06-01",
    "startTime": "09:15:00",
    "durationMinutes": 25,
    "timeOfDay": "MORNING"
  }
]
```

---

## 🔨 Building from Source

```bash
# Clone the repo
git clone https://github.com/YOUR_USERNAME/StudyTimer.git
cd StudyTimer

# Compile (ensure Gson jar is on classpath)
javac -cp lib/gson-2.10.1.jar -d out src/com/studytimer/**/*.java

# Package as runnable jar
jar cfm StudyTimer.jar MANIFEST.MF -C out .
```

Or open the project in **IntelliJ IDEA** / **Eclipse** and run `Main.java` directly.

---

## 🗺️ Roadmap

- [ ] Custom themes (light mode, additional color palettes)
- [ ] Export stats as CSV / PDF
- [ ] Session notes / tagging
- [ ] Global hotkeys for Start/Pause without focusing the window
- [ ] Tray icon support (minimize to system tray)
- [ ] Plugin system for custom chime sounds

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "feat: add your feature"`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

Please follow [Conventional Commits](https://www.conventionalcommits.org/) for commit messages.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">

Made with ☕ and deep focus sessions.

**[⬆ Back to top](#)**

</div>
