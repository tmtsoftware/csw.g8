# Releasing

Steps to release:

1. Change `csw` version in `src/main/g8/default.properties` and `README.md`
1. Make sure `dev` workflow is green in actions tab in github repo
1. Merge `dev` branch to `master` and then rebase `dev` on to `master` branch
1. Run `./release.sh $VERSION$` script by providing version number argument
    **Note:** `PROD=true` environment varibale needs to be set before running `release.sh`
