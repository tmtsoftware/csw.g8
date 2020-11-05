# Releasing

Steps to release:

1. Change `csw` version in `src/main/g8/default.properties` and `README.md`
2. Make sure `ci` workflow is green in actions tab in github repo
3. update `release.yml`
    Update step `Giter8 Compile csw.g8 with csw_version in default.properties` in `release.yml`
    Update `<****>` in `g8 tmtsoftware/csw.g8 -t <****> --name=galil` with csw.g8 version that you are going to release
    
    For example, if you are going to release `v3.0.0` of `csw.g8`
    then updated line in `release.yml` will look like `g8 tmtsoftware/csw.g8 -t v3.0.0 --name=galil`
        
4. Run `./release.sh $VERSION$` script by providing version number argument
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`

5. Tagging csw.g8 will trigger `release` workflow in github actions tab. Make sure that `release` workflow is green.
