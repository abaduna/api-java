function clickCreate() {
  console.log("click");
  let firsname = document.getElementById("txtfirnName").value;
  let lastname = document.getElementById("txtlastName").value;
  let email = document.getElementById("txtEmail").value;
  let addres = document.getElementById("txtAddres").value;
  let customer = {
    firsname: firsname,
    lastname: lastname,
    email: email,
    adress: addres,
  };
  Create(customer);
}
async function Create(customer) {
    if (window.location.href.includes("id=")) {
        let id = window.location.href.split("id=")[1];
        let url = URL_SERVER + "/customers/"+ id;

        let config = {
          method: "PUT",
          body: JSON.stringify(customer),
          headers: {
            "Content-Type": "application/json", // Fixed header key from "Headers" to "headers"
          },
        };
        await fetch(url, config);
        alert("modificador  exitosamente");
        window.location.href = "customers.html"
        return
    }
  let url = URL_SERVER + "/customers";

  let config = {
    method: "POST",
    body: JSON.stringify(customer),
    headers: {
      "Content-Type": "application/json", // Fixed header key from "Headers" to "headers"
    },
  };
  await fetch(url, config);
  alert("guardado exitosamente");
  window.location.href = "customers.html";
}

loadCostumers();
async function loadCostumers() {
    console.log("adress");
  if (!isNew()) {
    console.log("isnew");
    return;
  }
  let id = window.location.href.split("id=")[1];
  let customer = await getCustomers(id);
  document.getElementById("txtfirnName").value = customer.firsname;
  document.getElementById("txtlastName").value = customer.lastname;
  document.getElementById("txtEmail").value = customer.email;
  document.getElementById("txtAddres").value = customer.adress;
}
async function getCustomers(id) {
  let url = URL_SERVER + "/customers/" + id;

  let res = await fetch(url);
  let json = await res.json();

  return json;
}
function isNew() {
  return window.location.href.includes("id=");
}
