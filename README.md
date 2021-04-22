# Hotel_Management_System_Java

> Is a Java interactive Application that can handle request from client/customer for food/rooms and support other Hotel staff in management.

## Running Locally

Note: For this you need to install git on your machine. 
You can download the git tool from [here](https://git-scm.com/).

#### Clone 


- First, fork this repository.
- Run the following command in command prompt to clone your forked repo locally :

  ```bash
  $ git clone https://github.com/YOUR_GITHUB_USER_NAME/Hotel_Management_System_Java.git
  ```
  where ```YOUR_GITHUB_USER_NAME``` is your GitHub username.

#### Add upstream
- Run the following Command :
  ```bash
  $ git remote add upstream https://github.com/AtharvaAmrutkar0307/Hotel_Management_System_Java.git
  ```
- Check if the upstream is working :
  ```bash
  $ git remote -v
  origin  https://github.com/YOUR_GITHUB_USER_NAME/Hotel_Management_System_Java.git (fetch)
  origin  https://github.com/YOUR_GITHUB_USER_NAME/Hotel_Management_System_Java.git (push)
  upstream        https://github.com/AtharvaAmrutkar0307/Hotel_Management_System_Java.git (fetch)
  upstream        https://github.com/AtharvaAmrutkar0307/Hotel_Management_System_Java.git (push)
  ```
  
- To fetch latest changes from the upstream : 
    ```bash
    $ git fetch upstream
    ```
    
- To merge these changes : 
  ```bash
  $ git merge upstream/develop
  ```
  
## Contributing
- Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
- Please make sure to update tests as appropriate.
-  Commit some changes on your forked repository.
- Then, you'll see an option to send a pull request on the top right corner of your forked repository, click on it and create a pull request.
