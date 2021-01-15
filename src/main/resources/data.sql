insert into account_info(account_number,balance,LAST_UPDATED_TIME_STAMP) values ('123',300.5,TO_TIMESTAMP('2020-01-01T01:02:03.8Z', 'YYYY-MM-DD HH24:MI:SS'));


insert into transactions(id,account_number,amount,transaction_time,type) values (1,'123',300.5,TO_TIMESTAMP('2020-01-01T01:02:03.8Z', 'YYYY-MM-DD HH24:MI:SS'),'WITHDRAW');
insert into transactions(id,account_number,amount,transaction_time,type) values (2,'123',10.5,TO_TIMESTAMP('2021-01-01T01:02:03.8Z', 'YYYY-MM-DD HH24:MI:SS'),'WITHDRAW');
insert into transactions(id,account_number,amount,transaction_time,type) values (3,'123',10.5,TO_TIMESTAMP('2019-06-01T01:02:03.8Z', 'YYYY-MM-DD HH24:MI:SS'),'DEPOSIT');
insert into transactions(id,account_number,amount,transaction_time,type) values (5,'123',10.5,TO_TIMESTAMP('2015-01-01T01:02:03.8Z', 'YYYY-MM-DD HH24:MI:SS'),'DEPOSIT');