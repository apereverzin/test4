package com.my.tutorial.shop

fun Shop.getSetOfCustomers(): Set<Customer> =
        this.customers.toSet()

fun Shop.getCitiesCustomersAreFrom(): Set<City> =
        this.customers.map { it.city }.distinct().toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> =
        this.customers.filter { it.city == city }.distinct()

fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
        this.customers.all { it.city == city }

fun Shop.hasCustomerFrom(city: City): Boolean =
        this.customers.any { it.city == city }

fun Shop.countCustomersFrom(city: City): Int =
        this.customers.filter { it.city == city }.count()

fun Shop.findAnyCustomerFrom(city: City): Customer? =
        this.customers.find { it.city == city }

val Customer.orderedProducts: Set<Product> get() =
    this.orders.flatMap { it.products }.toSet()

val Shop.allOrderedProducts: Set<Product> get() =
    this.customers.flatMap { it.orders }.flatMap { it.products }.toSet()

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? =
        this.customers.maxBy { it.orders.size }

fun Customer.getMostExpensiveOrderedProduct(): Product? =
    this.orders.flatMap { it.products }.maxBy { it.price }

fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> =
        this.customers.sortedBy { it.orders.size }

fun Customer.getTotalOrderPrice(): Double =
        this.orders.flatMap { it.products }.map { it.price }.sum()

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
        this.customers.groupBy { it.city }

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> =
        customers.filter {
            val (delivered, undelivered) = it.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
        }.toSet()

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val allProducts = customers.flatMap { it.orders.flatMap { it.products } }.toSet()
    return customers.fold(allProducts, { orderedByAll, customer ->
        orderedByAll.intersect(customer.orders.flatMap { it.products }.toSet())
    })
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? =
        this.orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
        this.customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }

//fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String> {
//    val groupsByLength = collection.groupBy { it.length }
//
//    val maximumSizeOfGroup = groupsByLength.values.map { it.size }.max()
//
//    return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup }
//}
