package com.hans.belatrix.question.dao;

import com.hans.belatrix.question.entity.Log;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hans H. Bravo
 */
public interface ILogDAO extends CrudRepository<Log, Integer> {
}
