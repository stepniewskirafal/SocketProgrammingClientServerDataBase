/*
 * This file is generated by jOOQ.
 */
package database.tables.daos;


import database.tables.Message;
import database.tables.records.MessageRecord;

import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MessageDao extends DAOImpl<MessageRecord, database.tables.pojos.Message, Integer> {

    /**
     * Create a new MessageDao without any configuration
     */
    public MessageDao() {
        super(Message.MESSAGE, database.tables.pojos.Message.class);
    }

    /**
     * Create a new MessageDao with an attached configuration
     */
    public MessageDao(Configuration configuration) {
        super(Message.MESSAGE, database.tables.pojos.Message.class, configuration);
    }

    @Override
    public Integer getId(database.tables.pojos.Message object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<database.tables.pojos.Message> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Message.MESSAGE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<database.tables.pojos.Message> fetchById(Integer... values) {
        return fetch(Message.MESSAGE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public database.tables.pojos.Message fetchOneById(Integer value) {
        return fetchOne(Message.MESSAGE.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<database.tables.pojos.Message> fetchOptionalById(Integer value) {
        return fetchOptional(Message.MESSAGE.ID, value);
    }

    /**
     * Fetch records that have <code>topic BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<database.tables.pojos.Message> fetchRangeOfTopic(String lowerInclusive, String upperInclusive) {
        return fetchRange(Message.MESSAGE.TOPIC, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>topic IN (values)</code>
     */
    public List<database.tables.pojos.Message> fetchByTopic(String... values) {
        return fetch(Message.MESSAGE.TOPIC, values);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<database.tables.pojos.Message> fetchRangeOfContent(String lowerInclusive, String upperInclusive) {
        return fetchRange(Message.MESSAGE.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<database.tables.pojos.Message> fetchByContent(String... values) {
        return fetch(Message.MESSAGE.CONTENT, values);
    }

    /**
     * Fetch records that have <code>recipient BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<database.tables.pojos.Message> fetchRangeOfRecipient(String lowerInclusive, String upperInclusive) {
        return fetchRange(Message.MESSAGE.RECIPIENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>recipient IN (values)</code>
     */
    public List<database.tables.pojos.Message> fetchByRecipient(String... values) {
        return fetch(Message.MESSAGE.RECIPIENT, values);
    }

    /**
     * Fetch records that have <code>sender BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<database.tables.pojos.Message> fetchRangeOfSender(String lowerInclusive, String upperInclusive) {
        return fetchRange(Message.MESSAGE.SENDER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sender IN (values)</code>
     */
    public List<database.tables.pojos.Message> fetchBySender(String... values) {
        return fetch(Message.MESSAGE.SENDER, values);
    }
}
