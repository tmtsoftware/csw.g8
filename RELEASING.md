# Releasing

Steps to release:

1. Change `csw` version in `src/main/g8/project/build.properties`.
2. Make sure workflow is green in actions tab in github repo for dev branch.
3. Rebase dev branch with master branch.
4. Merge dev branch to master branch.    
5. Make sure workflow is green in actions tab in github repo for master branch.        
6. Run `./release.sh $VERSION$` script by providing version number argument.
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`.
7. After release is complete, change the `csw` version back to `0.1.0-SNAPSHOT` in `src/main/g8/project/build.properties` 
in dev branch.

**Note:** Tagging csw.g8 will again trigger `release` workflow in github actions tab. This will help in release status 
lookup in the future.
