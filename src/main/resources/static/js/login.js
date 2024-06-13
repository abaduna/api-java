
async function getLogin() {
    let url = URL_SERVER + "/auth/login";
    let email = document.getElementById("txtEmail").value;
    let password = document.getElementById("txtPassword").value; // corrected typo in variable name

    console.log('email', email);
    console.log('password', password);

    try {
        let response = await fetch(url, {
            method: "POST", // use uppercase for method names
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "email": email,
                "password": password
            })
        });


        if (!response.ok) {
            console.error('Server returned an error:', response.status, response.statusText);
            return;
        }

        let text = await response.text(); // Get raw text response
        console.log('response text', text);

       localStorage.setItem("Authorization",text)
       window.location.href = "customers.html"
    } catch (error) {
        console.error('Fetch error:', error);
    }
}
function logOut(){
    localStorage.setItem("Authorization","borrado")
}