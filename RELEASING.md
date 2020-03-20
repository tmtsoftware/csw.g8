# Releasing

Steps to release:

1. Change `csw` version in `src/main/g8/default.properties` and `README.md`
2. Merge `dev` branch to `master` and then rebase `dev` on to `master` branch
3. Run `giter8-prod` pipeline by providing `VERSION` number
