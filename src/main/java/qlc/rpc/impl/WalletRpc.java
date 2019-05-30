package qlc.rpc.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import qlc.network.QlcClient;
import qlc.network.QlcException;
import qlc.rpc.QlcRpc;

import java.io.IOException;

public class WalletRpc extends QlcRpc {
	
    public WalletRpc(QlcClient client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

	/**
     * Return balance for each token of the wallet
     * @param params string: master address of the wallet
                     string: passphrase
     * @return balance of each token in the wallet
     * @throws QlcException
     * @throws IOException
     */
    public JSONObject getBalances(JSONArray params) throws QlcException, IOException {
        return client.call("wallet_getBalances", params);
    }

    /**
     * Returns raw key (public key and private key) for a account
     * @param params string: account address
                     string: passphrase
     * @return private key and public key for the address
     * @throws QlcException
     * @throws IOException
     */
    public JSONObject getRawKey(JSONArray params) throws QlcException, IOException {
        return client.call("wallet_getRawKey", params);
    }

    /**
     * Generate new seed
     * @param params null
     * @return string: hex string for seed
     * @throws QlcException
     * @throws IOException
     */
    public JSONObject newSeed(JSONArray params) throws QlcException, IOException {
        return client.call("wallet_newSeed", params);
    }

    /**
     * Create new wallet and Return the master address
     * @param params string: passphrase
                     string: optional, hex string for seed, if not set, will create seed randomly
     * @return string : master address of the wallet
     * @throws QlcException
     * @throws IOException
     */
    public JSONObject newWallet(JSONArray params) throws QlcException, IOException {
        return client.call("wallet_newWallet", params);
    }


    /**
     * Change wallet password
     * @param params string: master address of the wallet
                     string: old passphrase
                     string: new passphrase
     * @return null
     * @throws QlcException
     * @throws IOException
     */
    public JSONObject changePassword(JSONArray params) throws QlcException, IOException {
        return client.call("wallet_changePassword", params);
    }

}