package __15__lang.object;

public class JavaLangClass {

	int number;
	String name;
	
	@Override
	public String toString() {
		return number + " / " + name;
	}
	
	@Override 
	public boolean equals(Object obj) {
		boolean ret = false;
		if(obj instanceof JavaLangClass) {
			JavaLangClass temp = (JavaLangClass) obj;
			if(this.number == temp.number && this.name != null && this.name.equals(temp.name)) {
				ret = true;
			}else {
				ret = false;
			}
		}
		return ret;	
	}
	
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) number;
		hash = 31 * hash + (name == null ? 0 : name.hashCode());
		return hash;
	}
}
