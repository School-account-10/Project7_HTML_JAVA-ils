# departements
dep = [1, 2, 3, 4, 5]  # Suppose there are N deps


e_data = {}

for i in range(int(input("How many emoloyees?: "))):
    n = input("Name: ")
    age = int(input("Age: "))
    cn = int(input("Contact Number: "))
    adr = str(input("Address Number: "))
    nd = int(input("Dapartment Number: "))
    p_f = str(input("Part-time or Full-time?: "))
    e_data[n] = {'Age': age, 'CN': cn,
                 'Address': adr, 'Department': nd, 'pf': p_f}

print("")
print("NAMES AND AGE")
print("")
for i, v in e_data.items():
    print(f"Name: {i}, Age: {v['Age']}")

print("")
print("DEPARTMENTS")
print("")
for i, v in e_data.items():
    print(f"Name: {i}, Department: {v['Department']}")

if p_f.lower() in ["full-time", "full", "fulltime"]:
    bs = float(int(input("Asking Salary: ")))
    sss = bs * 0.14
    ttl_tax = 0
    if sss >= 1500:
        ttl_tax += sss*0.01
    else:
        ttl_tax += sss*0.02

    ext_tax = bs * 0.045
    ttl_tax = round(sss+ttl_tax+ext_tax, 2)
    rt_tax = bs-ttl_tax

    print("TAX:", ttl_tax)
    print("Total:", round(rt_tax, 2))

elif p_f.lower() in ["part-time", "part", "partime"]:
    rh, wd = list(map(int, input("Rate per Hour, Work Days")))
    ot = str(input("Overtime?: "))
    if ot == "No":
        bs = float(int(input("Asking Salary: ")))
        bs = bs*(rh*1.25)
        sss = bs * 0.14
        ttl_tax = 0
        if sss >= 1500:
            ttl_tax += sss*0.01
        else:
            ttl_tax += sss*0.02

        ext_tax = bs * 0.045
        ttl_tax = round(sss+ttl_tax+ext_tax, 2)
        rt_tax = bs-ttl_tax

        print("TAX:", ttl_tax)
        print("Total:", round(rt_tax, 2))

    elif ot == "Yes":
        bp = (rh*wd*8)
        op = (rh*1.25)
        print("Total:", bp+op)
