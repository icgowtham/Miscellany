GitHub Navigator:
-----------------

1. Introduction: 
This is a Python Flask based application to search GitHub repositories by given search term and present them as html page. Jinja2 template (part of Flask) syntax is used to render dynamic HTML content. The application is developed using Python 3.


2. Bootstrapping Steps:
   1. Create a temporary directory on a machine running Linux (probably?):
      mkdir -p gow_solution

   2. Copy the contents of the zip file containing the solution to the directory created in the previous step.

   3. Switch to the directory created in step 1.

   4. Create a Python 3 virtual environment:
      virtualenv -p python3 env3
   
   5. Activate the virtual environment:
      source env3/bin/activate

   6. Install the application dependencies:
      pip3 install -r dependencies.txt

   7. Run the application:
      python3 application.py

   8. Open a web browser.

   9. Type the application URL in the browser and hit Enter:
      http://<the_machine_ip>:5000
      For e.g., if the machine IP is 192.168.1.111, then type http://192.168.1.111:5000
      NOTE: Ingress and Egress traffic on port 5000 should be enabled to view the application.

   10. Enter the search term in the textbox and click on 'Submit' button and hit Enter.


3. Contact:
   Please reach out to me at ic.gowtham@gmail.com in case of any questions regarding the application.
