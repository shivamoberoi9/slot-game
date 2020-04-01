package org.app.game.betting.dataaccessobject;

import org.app.game.betting.entity.RoundResult;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for all Crud Operation of Round.
 * @author shivamoberoi
 *
 */
public interface RoundResultRepository extends CrudRepository<RoundResult, Long>
{

}
