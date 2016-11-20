package gr.lolo.usertype;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class StringListType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { java.sql.Types.ARRAY };
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x != null ? x.hashCode() : 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        List<String> list = null;
        String nameVal = rs.getString(names[0]);
        if (nameVal != null) {
            nameVal = nameVal.substring(1,nameVal.length()-1);
            list = new LinkedList<>();
            StringTokenizer tokenizer = new StringTokenizer(nameVal, ",");
            while (tokenizer.hasMoreElements()) {
                String val = (String) tokenizer.nextElement();
                list.add(val);
            }
        }
        return list;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            Connection connection = st.getConnection();

            @SuppressWarnings("unchecked")
            List<String> castObject = (List<String>) value;
            st.setArray(index,  connection.createArrayOf("varchar", castObject.toArray()));
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() { return false; }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
