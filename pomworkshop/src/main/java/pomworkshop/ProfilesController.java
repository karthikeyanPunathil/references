package pomworkshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.events.Event.ID;

@RestController
public class ProfilesController {

	@Autowired
	ProfileRepository repo;

	@RequestMapping(value = "/saveProfile1", method = RequestMethod.POST, consumes = { "multipart/mixed" })
	public Profile getProfile(Profile profile, @RequestBody MultipartFile file) {

		try {
			profile.setImg(file.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repo.save(profile);

		return profile;

	}
	
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public Profile getProfile(Profile profile) {

		
		repo.save(profile);

		return profile;

	}

	@RequestMapping(value = "/getimg", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] getImage(int id) {
		Profile p = repo.findOne(id);
		return p.getImg();
	}

	@RequestMapping("/findOne")
	public ResponseEntity getOneProfile(@RequestParam long id) {
		Profile profile = repo.findOne(id);
		return new ResponseEntity(profile, HttpStatus.OK);
	}

	@RequestMapping("/findall")
	public List<Profile> getAll() {
		return repo.findAll();
	}

	@RequestMapping("/count")
	public long getCount() {
		return repo.count();
	}

	@RequestMapping("/delete")
	public String deleteContent(@RequestParam long id) {
		repo.delete(id);
		return "deleted";
	}

	@RequestMapping("/isexist")
	public boolean isExist(@RequestParam long id) {
		return repo.exists(id);
	}

	@RequestMapping("/firstnamelastname")
	public List<Profile> lastnamefirstname(@RequestParam String lastname, String firstname) {
		return repo.findByLastnameAndFirstname(lastname, firstname);
	}

	@RequestMapping("/firstorlastname")
	public List<Profile> lastOrFirst(@RequestParam String lastname, String firstname) {
		return repo.findByLastnameOrFirstname(lastname, firstname);
	}

	@RequestMapping("/firstname")
	public List<Profile> firtname(@RequestParam String firstname) {
		return repo.findByFirstname(firstname);
	}

	@RequestMapping("/lastname")
	public List<Profile> lastname(@RequestParam String lastname) {
		return repo.findByLastname(lastname);
	}

	@RequestMapping("/isfirstname")
	public List<Profile> isFirstname(@RequestParam String firstname) {
		return repo.findByFirstnameIs(firstname);
	}

	@RequestMapping("/firstnameequal")
	public List<Profile> firstnameequal(@RequestParam String firstname) {
		return repo.findByFirstnameEquals(firstname);
	}

	@RequestMapping("/startdatebtw")
	public List<Profile> betweenDate(Date dob1, Date dob2) {
		return repo.findByDobBetween(dob1, dob2);
	}

	@RequestMapping("/lessthanage")
	public List<Profile> lessthanage(int age) {
		return repo.findByAgeLessThan(age);
	}

	@RequestMapping("/greaterthanage")
	public List<Profile> greaterthanage(int age) {
		return repo.findByAgeGreaterThanEqual(age);
	}

	@RequestMapping("/lessequalage")
	public List<Profile> lessequaqlage(int age) {
		return repo.findByAgeLessThanEqual(age);
	}

	@RequestMapping("/greaterequalage")
	public List<Profile> greaterequalage(int age) {
		return repo.findByAgeGreaterThanEqual(age);
	}

	@RequestMapping("/isnullage")
	public List<Profile> getisnullage() {
		return repo.findByAgeIsNull();
	}

	@RequestMapping("/notnullage")
	public List<Profile> notnullage() {
		return repo.findByAgeNotNull();
	}

	@RequestMapping("/firstnamelike")
	public List<Profile> firstnamelike(String firstname) {
		return repo.findByFirstnameLike(firstname);
	}

	@RequestMapping("/firstnamenotlike")
	public List<Profile> firstnamenotlike(String firstname) {
		return repo.findByFirstnameNotLike(firstname);
	}

	@RequestMapping("/firstnamestartwith")
	public List<Profile> firstnamestartwith(String firstname) {
		return repo.findByFirstnameStartingWith(firstname);
	}

	@RequestMapping("/firstnamecontaining")
	public List<Profile> firstnamecontaining(String firstname) {
		return repo.findByFirstnameContaining(firstname);
	}

	@RequestMapping("/ageOrderByLastnameDesc")
	public List<Profile> ageOrderByLastnameDesc(int age) {
		return repo.findByAgeOrderByLastnameDesc(age);
	}

	@RequestMapping("/ageincollection")
	public List<Profile> ageincollection(@RequestParam Collection<Integer> age) {
		return repo.findByAgeIn(age);
	}

	@RequestMapping("/agenotincollection")
	public List<Profile> agenotincollection(@RequestParam Collection<Integer> age) {
		return repo.findByAgeNotIn(age);
	}

	@RequestMapping("/Lastnot")
	public List<Profile> LastnameNot(String lastname) {
		return repo.findByLastnameNot(lastname);
	}

	@RequestMapping("/firstnameignorecase")
	public List<Profile> firstnameignorecase(String firstname) {
		return repo.findByFirstnameIgnoreCase(firstname);
	}

	@RequestMapping("/activetrue")
	public List<Profile> activetrue() {
		return repo.findByActiveTrue();
	}

	@RequestMapping("/activefalse")
	public List<Profile> activefalse() {
		return repo.findByActiveFalse();
	}

}
