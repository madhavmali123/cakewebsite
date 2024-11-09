document.addEventListener("DOMContentLoaded", () => {
    fetchCakes();

    // Listen for form submit and call addCake function
    document.getElementById("cakeForm").addEventListener("submit", event => {
        event.preventDefault();
        addCake();
    });
});

function fetchCakes() {
    fetch("http://localhost:8080/cakes")
        .then(response => response.json())
        .then(cakes => {
            const cakesDiv = document.querySelector(".cakes-list"); // Update to the correct container for cakes
            cakesDiv.innerHTML = ""; // Clear existing content before adding new cakes
            cakes.forEach(cake => {
                const cakeElement = document.createElement("div");
                cakeElement.innerHTML = `
                    <img src="blog-img2.png" alt="Cake Image" width="200" height="200">
                    <p>${cake.name}</p>
                    <p>${cake.description}</p>
                    <p>$${cake.price}</p>
                `;
                cakesDiv.appendChild(cakeElement);
            });
        });
}

function addCake() {
    const name = document.getElementById("name").value;
    const description = document.getElementById("description").value;
    const price = document.getElementById("price").value;

    fetch("http://localhost:8080/cakes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ name, description, price })
    })
    .then(response => response.json())
    .then(newCake => {
        // Clear input fields after adding cake
        document.getElementById("name").value = "";
        document.getElementById("description").value = "";
        document.getElementById("price").value = "";
        // Re-fetch cakes to update the list
        fetchCakes();
    })
    .catch(error => console.error("Error adding cake:", error));
}
