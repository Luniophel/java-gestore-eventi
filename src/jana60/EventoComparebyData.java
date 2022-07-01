package jana60;

import java.util.Comparator;

public class EventoComparebyData implements Comparator<Evento>{

	@Override
	public int compare(Evento o1, Evento o2) {
		int value = o1.getData().compareTo(o2.getData());
		
		if (value == 0)
		{
			value =o1.getTitolo().compareTo(o2.getTitolo());
		}
		return value;
	}
}
