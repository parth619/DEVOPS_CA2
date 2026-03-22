document.getElementById('feedbackForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('studentName').value;
    const email = document.getElementById('emailId').value;
    const mobile = document.getElementById('mobileNumber').value;
    const dept = document.getElementById('department').value;
    const gender = document.querySelector('input[name="gender"]:checked');
    const comments = document.getElementById('comments').value;
    const errorDisplay = document.getElementById('error-message');

    // Validations
    if (name.trim() === "") { alert("Name is required"); return; }
    
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) { alert("Invalid Email format"); return; }

    if (!/^\d+$/.test(mobile) || mobile.length < 10) { 
        alert("Mobile number must be digits and at least 10 long"); return; 
    }

    if (!dept) { alert("Please select a department"); return; }
    if (!gender) { alert("Please select gender"); return; }

    const wordCount = comments.trim().split(/\s+/).length;
    if (wordCount < 10) {
        alert("Feedback must be at least 10 words.");
        return;
    }

    alert("Form Submitted Successfully!");
});