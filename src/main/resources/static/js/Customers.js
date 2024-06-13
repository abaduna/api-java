let token = localStorage.getItem("Authorization")
async function init() {
  renderCustomers();
  
}
async function getCustomers() {
  let url = URL_SERVER + "/customers";

  let res = await fetch(url,{
    method: "GET", 
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        "Authorization":token
    }
   
});
  let json = await res.json();

  return json;
}
async function renderCustomers() {
  let customers = await getCustomers();
  let html = "";

  for (let customer of customers) {
    html += getHtmlRowCustomers(customer);
  }
  let tbody = document.querySelector("#tbody");
  tbody.innerHTML = html;
}
async function onClickRemove(id) {
  let response = confirm("DO you wany remove this");
  let url = URL_SERVER + "/customers/" + id;

  let config = {
    method: "DELETE",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        "Authorization":token
    }
  };
  await fetch(url, config);
  init();
}
function onClickEdit(id) {
  window.location.href = `modificar-customers.html?id=${id}`
}
function getHtmlRowCustomers(customers) {
  return ` <tr>
                        <td>${customers.id}</td>
                        <td>${customers.firsname} ${customers.lastname}</td>
                        <td>${customers.email}</td>
                        <td>${customers.adress}</td>
                        <td>
                          <span onclick="onClickRemove(${customers.id})">
                            <i class="fas fa-trash p-5"></i>
                          </span>
                          <span onclick="onClickEdit(${customers.id})">
                            <i class="fas fa-edit" ></i>
                          </span>
                        </td>
             </tr>`;
}
init();
