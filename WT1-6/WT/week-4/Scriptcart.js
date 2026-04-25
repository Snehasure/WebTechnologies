const btnCart = document.querySelector('#cart-icon');
const cart = document.querySelector('.cart');
const btnClose = document.querySelector('#cart-close');

// Open Cart
btnCart.addEventListener('click', () => {
    cart.classList.add('cart-active');
});

// Close Cart
btnClose.addEventListener('click', () => {
    cart.classList.remove('cart-active');
});

// Load content after page loads
document.addEventListener('DOMContentLoaded', loadContent);

function loadContent() {

    // Remove item
    let btnRemove = document.querySelectorAll('.cart-remove');
    btnRemove.forEach((btn) => {
        btn.addEventListener('click', removeItem);
    });

    // Quantity change
    let qtyElements = document.querySelectorAll('.cart-quantity');
    qtyElements.forEach((input) => {
        input.addEventListener('change', changeQty);
    });

    // Add to cart
    let cartBtns = document.querySelectorAll('.add-cart');
    cartBtns.forEach((btn) => {
        btn.addEventListener('click', addCart);
    });

    updateTotal();
}

// Store cart items
let itemList = [];

// Remove Item
function removeItem() {
    if (confirm('Are you sure to remove?')) {
        let title = this.parentElement.querySelector('.cart-food-title').innerHTML;

        itemList = itemList.filter(el => el.title !== title);

        this.parentElement.remove();
        loadContent();
    }
}

// Change Quantity
function changeQty() {
    if (isNaN(this.value) || this.value < 1) {
        this.value = 1;
    }
    loadContent();
}

// Add to Cart
function addCart(e) {

    e.preventDefault(); // stop navigation

    let food = this.closest('.food-box');

    let title = food.querySelector('.food-title')?.innerText;
    let price = food.querySelector('.food-price')?.innerText;
    let imgSrc = food.querySelector('.food-img')?.src;

    if (!title || !price || !imgSrc) {
        console.error("Missing data");
        return;
    }

    let newProduct = { title, price, imgSrc };

    if (itemList.find(el => el.title === title)) {
        alert("Product already added to cart");
        return;
    }

    itemList.push(newProduct);

    let element = document.createElement('div');
    element.innerHTML = createCartProduct(title, price, imgSrc);

    document.querySelector('.cart-content').append(element);

    loadContent();
}
// Create Cart Item HTML
function createCartProduct(title, price, imgSrc) {
    return `
    <div class="cart-box">
        <img src="${imgSrc}" class="cart-img">
        <div class="detail-box">
            <div class="cart-food-title">${title}</div>
            <div class="price-box">
                <div class="cart-price">${price}</div>
                <div class="cart-amt">${price}</div>
            </div>
            <input type="number" value="1" class="cart-quantity">
        </div>
        <ion-icon name="trash" class="cart-remove"></ion-icon>
    </div>
    `;
}

// Update Total
function updateTotal() {
    const cartItems = document.querySelectorAll('.cart-box');
    const totalValue = document.querySelector('.total-price');

    let total = 0;

    cartItems.forEach(product => {
        let priceElement = product.querySelector('.cart-price');
        let price = parseFloat(priceElement.innerHTML.replace("Rs.", ""));

        let qty = product.querySelector('.cart-quantity').value;

        total += (price * qty);

        product.querySelector('.cart-amt').innerText = "Rs." + (price * qty);
    });

    totalValue.innerHTML = 'Rs.' + total;

    // Cart Count
    const cartCount = document.querySelector('.cart-count');
    let count = itemList.length;

    cartCount.innerHTML = count;

    if (count === 0) {
        cartCount.style.display = 'none';
    } else {
        cartCount.style.display = 'block';
    }
}