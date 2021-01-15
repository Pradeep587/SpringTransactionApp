# SpringTransactionApp




#Assumptions

1: Balances and transactions feeds will load the data to Relational Database using Kafka consumer
2: API needs two header parameters for authentication process . Error will be show if required header parameters are missing
	FYI..authentication mechanism is not implemented
3: Account Number is mandatory for the call to proceed.
	TrancationType,data range is optional
	
	


#Features
/transactions
1: Input : accountNumber    Output : account number , balance
2: Input: accountNumber,transactionType   output : account number,balance and List<transactions> of transactionType
3: Input: accountNumber,transactionType,startDate   output : account number,balance and List<transactions> after startdate
2: Input: accountNumber,transactionType,endDate   output : account number,balance and List<transactions> before endDate
2: Input: accountNumber,transactionType,startDate,endDate   output : account number,balance and List<transactions> in the date range



TODO:

1: Implement pagiantion at the API level
2: Implement Kafaka to producer and consumer to load data to DB.