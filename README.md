## 📂 Repository Structure – Week-wise Experiments (As in GitHub)

- Weeks 1–6 → **WT1-6**
- Week 8 → **Week-8**
- Week 9 → **Week-9**
- Week 10 → **BookStore1**
- Week 11 → **Week-11**
- Week 12 → **ShoppingCartApp**
- Week 13 → **Week-13**



Installations
Eclipse Installation:

✅ Step 1: Go to Eclipse download page

Open this link in your browser:

👉 [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/packages/release/2022-06/r/eclipse-ide-enterprise-java-and-web-developers)

📥 ✅ Step 2: Download Eclipse Installer

Click:

👉 Download x64

This downloads:

eclipse-installer.exe
⚙️ ✅ Step 3: Run the installer
Double-click eclipse-installer.exe
Wait for installer to open
💻 ✅ Step 4: Choose correct Eclipse version

You will see multiple options.

👉 Select:

Eclipse IDE for Enterprise Java and Web Developers

✔ This version includes:

JSP support
Servlet support
Web Tools Platform (WTP)
Required for Tomcat
📁 ✅ Step 5: Choose install location

Example:

C:\Users\surep\eclipse

Then click:

Install
⏳ Step 6: Accept license & wait
Accept terms
Wait 5–10 minutes
🚀 ✅ Step 7: Launch Eclipse

Click:

Launch
📂 ✅ Step 8: Select workspace

Eclipse will ask for workspace folder.

Use:

C:\Users\surep\eclipse-workspace

Click:

Launch
⚠️ IMPORTANT (Must do before Eclipse)
🔧 Install Java (JDK)

Check if Java exists:

java -version

If not installed:

👉 Download JDK (recommended JDK 17 or 21) from:
https://adoptium.net/

Install it before running Eclipse.

🎯 AFTER INSTALL (for your experiment)

Now you can follow your lab steps:

✔ Add Tomcat 9
✔ Configure server
✔ Run JSP/Servlet

🔧 (Optional but important)

If Tomcat v9.0 is not visible in Eclipse:

👉 Go to:

Help → Eclipse Marketplace

Search:

Web Tools Platform (WTP)

Install it


MYSQL installtion:
Download MySQL

Go to the official site: https://dev.mysql.com/downloads/installer/

Download MySQL Installer (Community Edition)
2. Run the Installer

7
Open the .msi file
Choose setup type:
Developer Default (recommended for beginners)

Includes:
MySQL Server
MySQL Workbench (GUI tool)
3. Install Required Dependencies

Installer may ask to install:

Visual C++ Redistributables
Click Execute → wait till complete

4. Configure MySQL Server
Choose:
Standalone MySQL Server
Configuration:
Port: 3306 (default)
Authentication: Use Strong Password Encryption

6. Set Root Password
Set a password for root user
⚠️ Don’t forget this — you’ll need it to log in
7. Finish Installation
Click Execute → Finish
8. Verify Installation
Open:
MySQL Workbench
OR
Command Prompt:
mysql -u root -p
Enter password → If it connects, you're done ✅
🎯 Example for your project
CREATE DATABASE bookstore;
USE bookstore;
⚠️ Common problems
❌ MySQL not connecting

👉 Check:

Server running
Correct password
❌ Port already used

👉 Change port to:

3307

Apache Tomcat Installation
✅ STEP 1: Download Apache Tomcat 10.1

Go to:

👉 https://tomcat.apache.org/

Navigate to:
👉 Tomcat 10 → Download

Download:

Core → Windows zip (or zip for all OS)
📁 ✅ STEP 2: Extract Tomcat
Right-click downloaded ZIP
Click Extract Here / Extract All

Example location:

C:\apache-tomcat-10.1
📂 Folder structure (important)
apache-tomcat-10.1/
├── bin        (startup/shutdown scripts)
├── conf       (server config)
├── webapps    (deploy apps)
├── lib        (libraries)
├── logs       (logs)

•	bin	→	Contains	startup	(startup.bat/startup.sh)	and	shutdown	scripts
(shutdown.bat/shutdown.sh)


💻 ✅ STEP 3: Open Eclipse

👉 Open Eclipse IDE for Enterprise Java and Web Developers

🖥️ ✅ STEP 4: Open Servers tab

If not visible:

Window → Show View → Servers
➕ STEP 5: Add Tomcat Server
In Servers tab → click:
No servers are available → Click this link
Select:
Apache → Tomcat v10.1 Server
Click Next
📁 STEP 6: Configure Tomcat path

Click:

Browse

Select:

C:\apache-tomcat-10.1

Click:

Finish
⚙️ ✅ STEP 7: Verify server configuration

Double-click server:

Check ports:

HTTP port → 8080
Shutdown → 8005

👉 If 8080 busy:
Change to:

8081
▶️ STEP 8: Start Tomcat

Right-click server → Click:

Start

Status should be:

Started, Synchronized
🌐 STEP 9: Test in browser

Open:
To confirm that Tomcat is running, open a web browser and enter:
   http://localhost:8080/


👉 You should see:
✔ Apache Tomcat welcome page

🎉 DONE!

Your Tomcat 10.1 is successfully configured
