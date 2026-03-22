cat <<EOF > README.md
# Student Feedback - DEVOPS CA2


### Stack:
- **Frontend:** HTML/CSS/JS (with validation)
- **Testing:** Selenium (Java)
- **CI/CD:** Jenkins & GitHub

### Execution:
1. Open **index.html** to view the form.
2. Run **java -jar form-test.jar** to trigger Selenium tests.
3. Use the **Jenkinsfile** to automate in Jenkins.

### Coverage:
- Validates empty fields, email format, and 10-word minimum feedback.
- Confirms successful submission alert.
EOF
