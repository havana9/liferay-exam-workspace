# User Crud Portlet

This portlet consists of a form to generate a user and store it in the database.
The portlet is composed of a first page, which is loaded by default, where there is a list of users created. From this page, selecting the **Add User** button, you access the second page where you can create a new user by filling in the following form fields:

 - FirstName
 - LastName
 - Birthdate
 - email
All fields of the form are required


# Instance Portlet

Go to the login page of the portal and enter with a user administrator. Select the  **+ button** at the top right, select **widget** and search by the name of the portlet. The portlet is in the Sample category


## Deploy Portlet on Liferay

 1. Download the github workspace project 
 2. Go to $workspaceFolder and open the **gradle.properties** file
 3. Uncomment **liferay.workspace.home.dir** property and fill it with the URL of your LiferayBundle folder. 
 4. Go to the $workspaceFolder and execute the gradle command gradlew deploy. This command build all portlet modules and deploy it on Liferay Portal.

If you dont have liferay bundle installed on your machine, you can download it from Liferay Page and follow the instructions on [Liferay Developer Network](https://portal.liferay.dev/docs/7-1/deploy/-/knowledge_base/d/preparing-for-install) to install it on your machine.

Another option is to go to **workspaceFolder** and execute the command **gradlew distBundleZIp.** 
The command download from Liferay site the bundle , deploy all modules in it and zip all in a file in **$workspaceFolder/dist** folder. you can extract this file in you machine and start the Liferay Portal









