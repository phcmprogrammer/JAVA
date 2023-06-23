package org.mybatis.jpetstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.Sequence;

@Mapper
public interface SequenceMapper {

	Sequence getSequence(Sequence sequence);

	void updateSequence(Sequence sequence);
}
