package warm.tool;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Host;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;

public class Aerospike {

    public static void main(String[] args) {

        // Connecting to a cluster

        /*
         * you can specify one or more nodes in cluster. Make sure the node specify here
         * should not down.
         * 
         * This node use to discover all the nodes in the cluster
         */
        Host[] hosts = new Host[] { new Host("127.0.0.1", 3000) };
        AerospikeClient asClient = new AerospikeClient(new ClientPolicy(), hosts);

        System.out.println("Connected to AS..");

        // Write operation
        /*
         * key A key is a structure containing Name space(database) Set name (table) key
         * (the value of primary key)
         */

        WritePolicy writePolicy = new WritePolicy();
        writePolicy.recordExistsAction = RecordExistsAction.UPDATE;
        writePolicy.expiration = 60;// 60 sec to live

        String namespace = "warehouse_control_tower";
        String slotSet = "cpt_slots";
        String pk = "158118_22-07-2020";

        Key key = new Key(namespace, slotSet, pk);
        Bin cptBin = new Bin("1595499430", "slot wise capacity");
        Bin overallbin = new Bin("overallbin", "over all bin");

        /*
         * Put can write multiple bins(colums) a single bin delete a bin TTL
         * 
         */
        asClient.put(writePolicy, key, cptBin, overallbin);

        System.out.println("successfully written in AS");

        // READ a record
        /*
         * Get operation return a record. You can read All bins(columns) or a specific
         * bin.
         * 
         * A RECORD consist of 1. generation 2. expiration 3. bin data
         * 
         */
        Record record = asClient.get(null, key);
        System.out.println("Read record: " + record);
        /*
         * Read record: (gen:1),(exp:333196298),(bins:(overallbin:over all
         * bin),(1595499430:slot wise capacity))
         * 
         */

        // Reading multiple records
        /*
         * Batch operation allow you to read many records in one operation. Send array
         * of keys and records will return the same order as key.
         */

        Key keys[] = new Key[] { new Key(namespace, slotSet, pk) };
        Record records[] = asClient.get(null, keys);
        System.out.println("bulk read record: " + records);

    }

}
