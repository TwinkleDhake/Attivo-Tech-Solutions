""" Q1. Take user input to write a python program for offline shopping cart asking for real-world items to add in cart and 
while making items bills through their particular item's barcode and in end ask for bag if needed? 
if 'Yes' then rupee 10 will be added in total bill and while making payment ask for payment method options like: 
Cash or Debit Card or Credit Card or UPI for payment purpose. """
import datetime
import random
import getpass
import time
import re
# Initialize database and cart
existing_barcode = set()
item_db = {}
cart = []
# Barcode generator helper
def generate_barcode(existing_barcode):
    while True:
        barcode = str(random.randint(8901000000000, 8901999999999))  # Indian-style barcode
        if barcode not in existing_barcode:
            return barcode
print("Welcome to the Offline Shopping Cart!")
print("You can enter any item name; we'll generate a barcode for it.")
# Step 1: Enter items
while True:
    item_name = input("Enter item name to add (or type 'done' to finish): ").strip().lower()
    if item_name == 'done':
        break
    if item_name in item_db:
        cart.append(item_name)
        print(f"Added: {item_db[item_name]['name']} - ₹{item_db[item_name]['price']}")
    else:
        try:
            price = float(input(f"Enter price for '{item_name}': ₹"))
            barcode = generate_barcode([item['barcode'] for item in item_db.values()])
            item_db[item_name] = {"barcode": barcode, "name": item_name.title(), "price": price}
            cart.append(item_name)
            print(f"✅ '{item_name.title()}' added with barcode {barcode} at ₹{price}")
        except ValueError:
            print("❌ Invalid price. Please enter a numeric value.")
# Step 2: Create item summary
item_count = {}
total = 0
for item_key in cart:
    item = item_db[item_key]
    name = item['name']
    price = item['price']
    if name in item_count:
        item_count[name]['qty'] += 1
    else:
        item_count[name] = {'price': price, 'qty': 1}
    total += price
# Step 3: Ask for bag
bag_needed = input("\n🛍️ Do you need a shopping bag for ₹10? (Yes/No): ").strip().lower()
bag_charge = 10 if bag_needed == 'yes' else 0
total += bag_charge
# Step 4: Payment method
print("\n💳 Choose payment method:")
print("1. Cash\n2. Debit Card\n3. Credit Card\n4. UPI")
method = input("Enter payment method number (1–4): ").strip()
payment_methods = {
    "1": "Cash",
    "2": "Debit Card",
    "3": "Credit Card",
    "4": "UPI"
}
def process_card(card_type):
    print(f"\n💳 {card_type} Payment")
    cardholder = input("Enter Cardholder Name: ").strip()
    card_number = input("Enter 16-digit Card Number: ").strip()
    expiry = input("Enter Expiry Date (MM/YY): ").strip()
    cvv = getpass.getpass("Enter CVV: ")
    if len(card_number) != 16 or not card_number.isdigit():
        print("❌ Invalid card number.")
        return f"{card_type} (Invalid)"
    if len(cvv) != 3 or not cvv.isdigit():
        print("❌ Invalid CVV.")
        return f"{card_type} (Invalid)"
    if not re.match(r"^(0[1-9]|1[0-2])/([0-9]{2})$", expiry):
        print("❌ Invalid expiry date format. Use MM/YY.")
        return f"{card_type} (Invalid)"
    print("Processing payment", end="")
    for _ in range(3):
        print(".", end="", flush=True)
        time.sleep(1)
    print(f"\n✅ Payment successful via {card_type}!")
    return card_type
# Handle payment method
payment_method = payment_methods.get(method, "Unknown")
if method == "1":
    print("💵 Please collect the cash from the customer.")
elif method == "2":
    payment_method = process_card("Debit Card")
elif method == "3":
    payment_method = process_card("Credit Card")
elif method == "4":
    print("\n📱 UPI Payment")
    upi_id = input("Enter UPI ID (e.g., yourname@bank): ").strip()
    if not re.match(r"^[\w.-]+@[\w.-]+$", upi_id):
        print("❌ Invalid UPI ID format.")
        payment_method = "UPI (Invalid)"
    else:
        print("Sending UPI request", end="")
        for _ in range(3):
            print(".", end="", flush=True)
            time.sleep(1)
        print("\n✅ Payment successful via UPI!")   
# Step 5: Generate and save receipt
timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
receipt_lines = []
receipt_lines.append("====== OFFLINE SHOPPING RECEIPT ======\n")
receipt_lines.append(f"Date & Time: {timestamp}\n")
receipt_lines.append("--------------------------------------")
for item, info in item_count.items():
    qty = info['qty']
    price = info['price']
    line_total = qty * price
    receipt_lines.append(f"{item} x {qty} = ₹{line_total:.2f}")
receipt_lines.append("--------------------------------------")
if bag_charge:
    receipt_lines.append(f"Bag Charge       = ₹{bag_charge}")
receipt_lines.append(f"TOTAL AMOUNT     = ₹{total:.2f}")
receipt_lines.append(f"Payment Method   = {payment_method}")
receipt_lines.append("\nThank you for shopping with us!")
receipt_lines.append("======================================")
# Print and save receipt
print("\n\n".join(receipt_lines))
filename = f"receipt_{datetime.datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
with open(filename, "w", encoding="utf-8") as f:
    for line in receipt_lines:
        f.write(line + "\n")
print(f"\n🧾 Receipt saved as: {filename}")