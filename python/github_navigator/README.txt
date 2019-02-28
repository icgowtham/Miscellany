GitHub Navigator:
-----------------

1. Introduction: 
This is a Python Flask based application to search GitHub repositories by given search term and present them as html page. Jinja2 template (part of Flask) syntax is used to render dynamic HTML content. The application is developed using Python 3.


2. Bootstrapping Steps:
   1. Clone the repository.

   2. Change to the directory containing the source files.

   3. Create a Python 3 virtual environment:
      virtualenv -p python3 env3
   
   4. Activate the virtual environment:
      source env3/bin/activate

   5. Install the application dependencies:
      pip3 install -r dependencies.txt

   6. Run the application:
      python3 application.py

   7. Open a web browser.

   8. Type the application URL in the browser and hit Enter:
      http://<the_machine_ip>:5000
      For e.g., if the machine IP is 192.168.1.111, then type http://192.168.1.111:5000
      NOTE: Ingress and Egress traffic on port 5000 should be enabled to view the application.

   9. Enter the search term in the textbox and click on 'Submit' button and hit Enter.
