package com.gbs;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class Test {

    public static void main(String [] a){

        //{	{	F1 IS NOT_NULL	AND	F1 EQUALS 'INDIA'	}	OR	{	F2 IS NOT_NULL	AND	F1 EQUALS 'USA'	}	}
        // AND	{	F4 IS NOT_NULL	AND	F4 EQUALS 'MALE'	}

        Restrictions.conjunction().add(
            Restrictions.disjunction().add(
                Restrictions.conjunction()
                    .add(Restrictions.isNotNull("F1"))
                    .add(Restrictions.eq("F1", "INDIA"))).add(

                    Restrictions.conjunction()
                            .add(Restrictions.isNotNull("F2"))
                            .add(Restrictions.eq("F2", "USA")))

            )
        .add(Restrictions.conjunction()
                .add(Restrictions.isNotNull("F4"))
                .add(Restrictions.eq("F4", "MALE")));
    }
}
