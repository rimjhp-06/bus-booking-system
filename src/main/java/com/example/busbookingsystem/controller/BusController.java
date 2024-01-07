// src/main/java/com/yourcompany/busbookingsystem/controller/BusController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{busId}")
    public Bus getBusById(@PathVariable Long busId) {
        return busService.getBusById(busId);
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busService.addBus(bus);
    }

    @PutMapping("/{busId}")
    public Bus updateBus(@PathVariable Long busId, @RequestBody Bus bus) {
        return busService.updateBus(busId, bus);
    }

    @DeleteMapping("/{busId}")
    public void deleteBus(@PathVariable Long busId) {
        busService.deleteBus(busId);
    }

    // Other endpoints for bus management
}
