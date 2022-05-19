// Solidity program
// to store
// TransactionLifeCycle Details
pragma solidity >=0.7.0 <0.9.0;

// Creating a Smart Contract
contract Tlc{

    // Structure of TransactionLifeCycle
    struct TransactionLifeCycle{

        // State variables
        int tlcId;
        bool request;
        bool response;
        bool acknowledgement;
    }

    TransactionLifeCycle []transactions;
    mapping (
    int => TransactionLifeCycle) result;

    function add_request(int _tlcId) public {
        TransactionLifeCycle storage transaction = result[_tlcId];
        transaction.tlcId=_tlcId;
        transaction.request=true;
    }
    function add_response(int _tlcId) public {
        TransactionLifeCycle storage transaction = result[_tlcId];
        transaction.tlcId=_tlcId;
        transaction.response=true;
    }
    function add_acknowledgement(int _tlcId) public {
        TransactionLifeCycle storage transaction = result[_tlcId];
        transaction.tlcId=_tlcId;
        transaction.acknowledgement=true;
    }

    // Function to get
    // details of TransactionLifeCycle
    function getTransactionLifeCycle( int tlcId ) public view returns(
        bool request,
        bool response,
        bool acknowledgement){

        TransactionLifeCycle storage transaction = result[tlcId];

        return (transaction.request,transaction.response,transaction.acknowledgement);

        // If provided TransactionLifeCycle
        // id is not present
        // it returns Not
        // Found
        //return("Not Found",
        //"Not Found",
        //"Not Found");
    }
}

