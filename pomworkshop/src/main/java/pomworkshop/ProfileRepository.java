package pomworkshop;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
	
 <T extends Profile>T save(T p);
 Profile findOne(long primaryKey);
 
 
 List<Profile> findByLastnameAndFirstname(String lastname,String firstname);
 List<Profile> findByLastnameOrFirstname(String lastname,String firstname);
 List<Profile> findByFirstname(String firstname);
 List<Profile> findByLastname(String lastname);
 List<Profile> findByFirstnameIs(String firstname);
 List<Profile> findByFirstnameEquals(String firstname);
 List<Profile> findByDobBetween(Date dob1,Date dob2 );
 
 List<Profile> findByAgeLessThan(int age);
 List<Profile> findByAgeLessThanEqual(int age);
 List<Profile> findByAgeGreaterThan(int age);
 List<Profile> findByAgeGreaterThanEqual(int age);
 List<Profile> findByAgeIsNull();
 List<Profile> findByAgeNotNull();
 
 List<Profile> findByFirstnameLike(String firstname);
 List<Profile> findByFirstnameNotLike(String firstname);
 List<Profile> findByFirstnameStartingWith(String firstname);
 List<Profile> findByFirstnameEndingWith (String firstname);
 List<Profile> findByFirstnameContaining(String firstname);
 
 List<Profile> findByAgeOrderByLastnameDesc(int age);
 List<Profile> findByLastnameNot(String lastname);
 List<Profile> findByFirstnameIgnoreCase(String firstname);
 
 List<Profile> findByAgeIn(Collection<Integer> age);
 List<Profile> findByAgeNotIn(Collection<Integer> age);
 List<Profile> findByActiveTrue();
 List<Profile> findByActiveFalse();
 
 List<Profile> findByImg(int id);
 
}
