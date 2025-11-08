# CrackingCodingInterview
Coding Interview Problems from the Book

<!-- GitHub Actions status badge: uses the `CI` workflow added at `.github/workflows/ci.yml` -->
[![CI](https://github.com/Ermac517/CrackingCodingInterview/actions/workflows/ci.yml/badge.svg)](https://github.com/Ermac517/CrackingCodingInterview/actions/workflows/ci.yml)

## Build

Prerequisites:

- Java 21 (JDK)
- No system Gradle required — this repo uses the Gradle wrapper (`gradlew`).

Basic commands (from the repository root):

```bash
# Make wrapper executable (Unix/macOS)
chmod +x ./gradlew

# Clean, compile and run tests
./gradlew clean build

# Run tests only
./gradlew test
```

If you prefer to run with your system Gradle, you can run `gradle clean build`, but using `./gradlew` ensures the correct Gradle version (Gradle 8.6) is used.

Notes:

- CI runs the same `./gradlew clean build` on each push/PR using JDK 21.
- If you encounter JVM path issues, make sure `JAVA_HOME` points at a JDK installation directory (e.g., `/usr/lib/jvm/<jdk>` on Linux).

Formatting enforcement:

- The repository CI enforces code formatting using Spotless (`google-java-format`). The CI workflow runs `./gradlew spotlessCheck` before the build; if formatting fails the job will print guidance and fail.
- To fix formatting locally, run:

```bash
./gradlew spotlessApply
git add -A
git commit -m "Apply Spotless formatting"
```

