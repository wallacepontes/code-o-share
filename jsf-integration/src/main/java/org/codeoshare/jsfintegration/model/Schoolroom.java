package org.codeoshare.jsfintegration.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cos_schoolroom")
public class Schoolroom {
	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private PeriodType periodType;
}
