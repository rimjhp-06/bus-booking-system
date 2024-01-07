// src/main/java/com/yourcompany/busbookingsystem/service/BusService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long busId) {
        Optional<Bus> optionalBus = busRepository.findById(busId);
        return optionalBus.orElse(null);
    }

    public Bus addBus(Bus bus) {
        // Add your validation logic here if needed
        return busRepository.save(bus);
    }

    public Bus updateBus(Long busId, Bus updatedBus) {
        Optional<Bus> optionalBus = busRepository.findById(busId);

        if (optionalBus.isPresent()) {
            Bus existingBus = optionalBus.get();
            // Update the fields based on your requirements
            existingBus.setBusName(updatedBus.getBusName());
            existingBus.setTotalSeats(updatedBus.getTotalSeats());
            existingBus.setCurrentOccupancy(updatedBus.getCurrentOccupancy());
            existingBus.setAvailableDays(updatedBus.getAvailableDays());

            return busRepository.save(existingBus);
        } else {
            return null; // Bus not found
        }
    }

    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }

    // Other service methods as needed
}
