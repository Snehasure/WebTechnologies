function addToCart(productId) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "cart", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onload = function () {
        if (xhr.status == 200) {
            let data = xhr.responseText.split("\n");
            let output = "";
            data.forEach(line => {
                if (line.trim() != "") {
                    output += "<p>" + line + "</p>";
                }
            });
            // Update the display div without reloading
            document.getElementById("status").innerHTML = output;
        }
    };
    // Send data to servlet
    xhr.send("productId=" + productId + "&quantity=1");
}