# YourHeartIsMyHeart

**Version:** 1.0
**Author:** MimoAlexer
**Minecraft Version:** 1.20.5
**API Version:** Paper

## Overview

YourHeartIsMyHeart is a lightweight yet powerful PaperMC plugin designed to bring a new level of connectivity to your Minecraft server by synchronizing damage among every online player. Whenever a single player takes damage—whether from a hostile mob, environmental hazard, or even fall damage—all other players currently online will instantly receive the exact same amount of damage. This feature can turn ordinary combat scenarios into shared experiences, encouraging cooperation and adding an exciting twist to standard gameplay.

In addition to the core shared-damage functionality, the plugin includes an optional **debug mode**. When activated, debug mode broadcasts real-time details of each damage event—specifying which player was damaged, how much health was lost, and the exact cause—to all server operators. These messages appear in striking red chat color, making it easy for staff to monitor, troubleshoot, and understand how damage is being propagated across the server.

## Features

* **Shared Damage Propagation**: Automatically share the precise amount of damage one player takes with every other online player, ensuring a synchronized health experience.
* **Seamless Toggle**: Instantly enable or disable the shared-damage mechanic during gameplay without restarting the server.
* **Real-Time Debugging**: Activate debug mode to receive live feedback in your chat window, helping administrators diagnose and fine-tune plugin behavior.
* **Permission-Based Control**: Restrict usage to operators or designated permission holders to prevent unauthorized toggling.
* **Minimal Footprint**: Lightweight code designed for optimal performance on both small and large servers.

## Commands

All commands are executed via the `/heart` base command and require the `yourheartis.myheart.use` permission (default granted to OPs). Commands are case-insensitive for ease of use.

| Usage                | Description                                                                 |
| -------------------- | --------------------------------------------------------------------------- |
| `/heart start`       | Activates the shared damage system, applying incoming damage universally.   |
| `/heart stop`        | Deactivates the shared damage system, restoring individual health behavior. |
| `/heart debug start` | Turns on debug mode, sending detailed damage messages in red to operators.  |
| `/heart debug stop`  | Turns off debug mode, silencing further debug messages.                     |

## Permissions

| Permission                | Description                             | Default |
| ------------------------- | --------------------------------------- | ------- |
| `yourheartis.myheart.use` | Grants access to all `/heart` commands. | OP only |

## Installation

1. **Download** the latest release JAR from the [Releases page](https://github.com/yourusername/YourHeartIsMyHeart/releases).
2. **Copy** `YourHeartIsMyHeart.jar` into your server’s `plugins` directory.
3. **Restart or Reload** your server (`/reload` or stop and start) to generate necessary plugin metadata.
4. **Verify** the plugin is loaded by checking the console for `YourHeartIsMyHeart enabled.`

## Usage Guide

1. **Enable Shared Damage**: As an operator (or a player with permission), type `/heart start` in chat. You’ll receive a green confirmation message.
2. **Disable Shared Damage**: To stop the damage-sync effect, enter `/heart stop`. A green message confirms the deactivation.
3. **Activate Debug Mode**: Run `/heart debug start` to start receiving red chat alerts for each damage event, visible only to operators.
4. **Deactivate Debug Mode**: Enter `/heart debug stop` when you no longer need detailed logs.

*Tip:* Use debug mode during large-scale events or stress tests to ensure damage distribution is functioning as expected.

## Development & Contribution

Contributions, bug reports, and feature requests are welcome! Feel free to fork the repository and submit pull requests via GitHub:

* **Repository:** `https://github.com/yourusername/YourHeartIsMyHeart`
* **Issue Tracker:** `https://github.com/yourusername/YourHeartIsMyHeart/issues`

### Building Locally

1. Clone this repo: `git clone https://github.com/yourusername/YourHeartIsMyHeart.git`
2. Navigate into the folder: `cd YourHeartIsMyHeart`
3. Build with Maven:

   ```bash
   mvn clean package
   ```
4. Your compiled JAR will be located in the `target/` directory.

## Configuration

No additional configuration files are required—the plugin is fully managed via in-game commands. Future versions may introduce a config file for advanced settings.

## License

This project is open-source under the MIT License. You’re free to use, modify, and distribute it. For full terms, see the [LICENSE](LICENSE) file.

---

*Thank you for using YourHeartIsMyHeart! May your server’s hearts forever beat as one.*
