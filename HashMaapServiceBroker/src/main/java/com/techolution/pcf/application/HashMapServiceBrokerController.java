package com.techolution.pcf.application;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handle all PUT ,DELETE,GET,ADD Operations on HashMap Service broker
 * 
 * @author naveenkumar300@gmail.com
 *
 */
@RestController
@RequestMapping("/customers")
public class HashMapServiceBrokerController{
    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapServiceBrokerController.class);
    private Map<String, Map<Object, Object>> hashMaps = new HashMap<>();



    
  
    /**
     * Method is use put the  instance id  in hashmap
     * 
     * @param instanceId
     * 
     * @return ResponseEntity
     * 
     */
    
    @RequestMapping(value = "/{instanceId}", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE)
    public ResponseEntity<String> hashMapPutInstanceId(@PathVariable String instanceId) {
        System.out.println("hashMapPutInstanceId"+instanceId);
     
        hashMaps.put(instanceId, new HashMap<Object, Object>());
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    /**
     * Method is use PUT the  value in hashmap
     * 
     * @param instanceId
     * @param key
     * @param value
     * @return ResponseEntity
     * 
     */

    @RequestMapping(value = "/{instanceId}/{key}/{value}", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE)
    public ResponseEntity<String> putHashMapOperation(@PathVariable String instanceId,@PathVariable String key,@PathVariable String value) {
        System.out.println("putHashMapOperation"+instanceId+key+value);
     
            Map<Object, Object> hashMapInstance = hashMaps.get(instanceId);
            hashMapInstance.put(key, value);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    /**
     * Method is use GET the  value in hashmap
     * 
     * @param instanceId
     * @param key
     * @return ResponseEntity
     * 
     */

    @RequestMapping(value = "/{instanceId}/{key}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
    public ResponseEntity<Object> getHashMapOperation(@PathVariable String instanceId,@PathVariable String key) {
        System.out.println("getHashMapOperation"+instanceId+key);
        Map<Object, Object> hashMapInstance = hashMaps.get(instanceId);
        Object objVal =hashMapInstance.get(key);
        if (objVal != null) {
       return new ResponseEntity<>(objVal, HttpStatus.OK);
       } else {
     return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
      }
    }
    /**
     * Method is use DELETE the  value in hashmap
     * 
     * @param instanceId
     * @param key
     * @return ResponseEntity
     * 
     */

    @RequestMapping(value = "/{instanceId}/{key}", method = RequestMethod.DELETE, produces = MediaType.ALL_VALUE)
    public ResponseEntity<Object> deleteHashMapOperation(@PathVariable String instanceId,@PathVariable String key) {
        System.out.println("deleteHashMapOperation"+instanceId+key);
        Map<Object, Object> hashMapInstance = hashMaps.get(instanceId);
        Object objVal =hashMapInstance.get(key);
        if (objVal != null) {
        	
       return new ResponseEntity<>(objVal, HttpStatus.OK);
       } else {
     return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
      }
    }
    
    
    
    
}
