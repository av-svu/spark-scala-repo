## Prerequisites
1. [IntelliJ IDEA 2022.3.2 (Community Edition)](https://www.jetbrains.com/idea/download/other.html)
2. [Java JDK 11.0.2](https://jdk.java.net/archive/)

## Git Workflow

The repo follows GitHub flow which is a lightweight workflow. It was created by [GitHub in 2011](http://scottchacon.com/2011/08/31/github-flow.html) and respects the following 6 principles:

1. Anything in the master branch is deployable
1. To work on something new, create a branch off from master and given a descriptively name(ie: new-oauth2-scopes)
1. Commit to that branch locally and regularly push your work to the same named branch on the server
1. When you need feedback or help, or you think the branch is ready for merging, open a pull request
1. After someone else has reviewed and signed off on the feature, you can merge it into master
1. Once it is merged and pushed to master, you can and should deploy immediately

### Advantages
* It is friendly for the Continuous Delivery and Continuous Integration
* A simpler alternative to Git Flow
* It is ideal when it needs to maintain single version in production
### Limitations
* The production code can become unstable most easily
* Are not adequate when it needs the release plans
* It doesn’t resolve anything about deploy, environments, releases, and issues
* It isn’t recommended when multiple versions in production are needed


## Git Commands

### If cloning first time:

1. Create branch in remote server (github/bitbucket/gitlab etc)

1. Clone repo. this should pull all branches.
   * git clone < repo url >

1. Make sure you are on latest main branch
   * git checkout main
   * git pull

1. Create local branch (feature/hotfix)
   * git checkout -b <feature/setup>

1. Update your code and commit and commit changes to new branch
   * git add .
   * git commit -m "feature/setup initial version"
   
1. Push feature branch to remote
   * git push origin feature/setup

1. Create pull request, review and merge feature branch to main in remote server

1. Sync changes from remote repo to local repo
   * git checkout main
   * git pull

1. Delete local and remote feature branches if not needed
   * git branch -d feature/setup
   * git push origin --delete feature/setup

1. To get rid of deleted branches
   * git fetch -p



### If the repo is already cloned:

1. Create branch in remote server (github/bitbucket/gitlab etc)

1. Open the project
 
1. Make sure you are on latest main branch and pull newly created remote branch
   * git checkout main
   * git pull

1. Create local branch (feature/hotfix)
   * git checkout -b <feature/setup>


1. Update your code and commit changes to new branch
   * git add .
   * git commit -m "feature/setup initial version"

1. Push feature branch to remote
   * git push origin feature/setup

1. Create pull request, review and merge feature branch to main in remote server

1. Sync changes from remote repo to local repo
   * git checkout main
   * git pull

1. Delete local and remote feature branches if not needed
   * git branch -d feature/setup
   * git push origin --delete feature/setup

1. To get rid of deleted branches
   * git fetch -p

