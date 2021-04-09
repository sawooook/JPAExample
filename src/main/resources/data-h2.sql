-- User 데이터 생성
INSERT INTO user(user_seq,name,email,passwd) VALUES (null,'tester','tester@gmail.com','$2a$10$mzF7/rMylsnxxwNcTsJTEOFhh1iaHv3xVox.vpf6JQybEhE4jDZI.');

-- Product 데이터 생성
INSERT INTO product(product_seq,name,details,review_count) VALUES (null,'Product A',null,0);
INSERT INTO product(product_seq,name,details,review_count) VALUES (null,'Product B','Almost sold out!',1);
INSERT INTO product(product_seq,name,details,review_count) VALUES (null,'Product C','Very good product',0);

-- Review 데이터 생성
INSERT INTO review(review_seq,user_seq,product_seq,content) VALUES (null,1,2,'I like it!');

-- Order 데이터 생성
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,1,0,'REQUESTED',null,null,null,null);
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,1,0,'ACCEPTED',null,null,null,null);
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,2,0,'SHIPPING',null,null,null,null);
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,2,1,'COMPLETED','plz send it quickly!',null,'2021-01-24 12:10:30',null);
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,3,0,'COMPLETED',null,null,'2021-01-24 10:30:10',null);
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,3,0,'REJECTED',null,'No stock',null,'2021-01-24 18:30:00');
INSERT INTO orders(order_seq,user_seq,product_seq,review_seq,state,request_msg,reject_msg,completed_at,rejected_at) VALUES (null,1,3,0,'REQUESTED',null,null,null,null);
