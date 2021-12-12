# Product-Feed-PlatForm

A platform that provides sellers a way to showcase their products.
Seller is someone who publishes product posts.
● Sellers can publish posts. A post contains product details. Eg. Product name, Price, category
etc.
● A seller has a rating which is a constant in the beginning.
A customer has an interest in these posts
● Customers can subscribe to sellers.
● Customers can unsubscribe to sellers.
A Customer has access to a product feed where they can see posts by sellers whom they have subscribed to.
Product Feed Platform:
● Customers only see posts that are posted by sellers they have subscribed to.
● Sellers can delete a post, if a post is deleted a customer won't see it in their feed. If a seller is
deleted, all their posts should get deleted.
● Customer can fetch subscribed feeds based on ranking function, one ranking function will be
default:
Feed ranking will be based on a single ranking function at a time.
■ Sort by recency of post (Default and mandatory)
■ Sort by seller rating (optional)
Features expected:
1. Seller
a. Seller can be created using platform
b. Seller can publish multiple posts.
2. Customer
a. Customers can be created using a platform.
b. Customers can get a list of existing sellers.
c. Customers can subscribe to sellers.
3. Feed
a. Customer can fetch feeds based on Ranking function.
4. Seller can delete his multiple posts. 5. Customer can unsubscribe to sellers.
6. Bonus(only attempt if time permits):
Customers can upvote/downvote a product post by a seller.
Seller’s current rating will be function of total upvotes & downvotes on their posts. For simplicity consider rating = Positive of [5 * (total upvotes)/(total upvotes + total downvotes)]. ie. Here 5 is beginning rating.
Expectations:
1. Make sure that you have working, functionally correct and demonstrable code.
2. Work on the expected output first and then add good-to-have features of your own.
3. Code should be modular, readable and testable.
4. Separation of concern should be addressed.
5. Code should easily accommodate new requirements with minimal changes.
Other Details:
1. Do not use any database or NoSQL store, use in-memory data-structure for simplicity.
2. Do not create any UI for the application.
3. Write a driver class for demo purpose. Which will execute all the features at one place in the
code to test all cases.
Sample Test Cases : Creating Seller
- Create sellers with name and rating :(Tony, 4),(Thor, 3)
Adding post
- Tony publishes a post 1: Macbook pro, price 2,00,000 rupees | 30 Nov, 2019 3 pm.
- Tony publishes a post 2: One Plus 7 pro phone, price 50,000 rupees | 30 Nov, 2019 4 pm.
- Thor publishes a post 3 : Macbook pro, price 1,80,000 rupees | 30 Nov, 2019 5 pm.
- Thor publishes a post 4: One Plus 7 pro phone with price 60,000 rupees | 30 Nov, 2019 7
pm.
Creating Customer
- Create a customer : Thanos
Other features
- Thanos fetches list of existing sellers : [Tony, Thor]
- Thanos subscribes to Tony
- Thanos subscribes to Thor
- Thanos fetches feed based on recency of post
One Plus 7 pro phone with price 60,000 rupees Macbook pro with price 1,80,000 rupees
One Plus 7 pro phone with price 50,000 rupees Macbook pro with price 2,00,000 rupees
- Tony deletes post 6 // Invalid operation, should not be allowed
- Thor deletes post 3
- Thanos fetches feed based on seller rating
Macbook pro with price 2,00,000 rupees
One Plus 7 pro phone with price 50,000 rupees One Plus 7 pro phone with price 60,000 rupees
- Thanos unsubscribe Tony
- Thanos fetches feed based on seller rating
          One Plus 7 pro phone with price 60,000 rupees
