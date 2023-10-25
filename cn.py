import random
import time

class NoisyChannelSimulation:
    def __init__(self, packet_loss_prob):
        self.packet_loss_prob = packet_loss_prob
        self.sender_data = list(range(1, 11))
        self.receiver_data = []
        self.window_size = 4
        self.base = 0
        self.next_seq_num = 0

    def simulate_stop_and_wait(self):
        time_unit = 1  # Time unit
        time_elapsed = 0
        
        for packet in self.sender_data:
            while True:
                print(f"\n --> Sending packet: {packet}")
                time.sleep(0.5)
                time_elapsed += time_unit
                
                if random.random() > self.packet_loss_prob:
                    print(f"✓ Packet {packet} sent successfully")
                    received_ack = False
                    ack_wait_time = 0
                    while not received_ack:
                        print("Waiting for ACK...")
                        time.sleep(time_unit)  # Time for waiting ACK
                        time_elapsed += time_unit
                        if random.random() > self.packet_loss_prob:
                            print(f"✓ ACK received for packet: {packet}")
                            received_ack = True
                        else:
                            print("✗ ACK lost, resending packet")
                            ack_wait_time += time_unit
                            time_elapsed += time_unit
                    print(f"Time elapsed: {ack_wait_time + 2 * time_unit} units")  # Sending + waiting time
                    break
                else:
                    print(f"✗ Packet {packet} lost")
                    
        print(f"\n\n🕔 Total time taken: {time_elapsed} seconds")

    def simulate_go_back_n(self):
            time_unit = 1  # Time unit
            time_elapsed = 0
            number_of_packets = 7;
            window_size = 3;
            current_send = 0;
            current_ack = 0;
            while current_send <= number_of_packets:
                for i in range(window_size):
                    if (current_send <= number_of_packets):
                        print(f" --> Sending packet: {current_send}")
                        time.sleep(0.2)
                        time_elapsed += time_unit
                        current_send += 1
                    else:
                        break;
                print("\n")
                
                for i in range(window_size):
                    
                    if (current_ack <= number_of_packets):
                        if (random.random() > self.packet_loss_prob):
                            print(f"✓ ACK received for packet: {current_ack}")
                            time.sleep(0.2)
                            time_elapsed += time_unit
                            current_ack += 1
                        else:
                            print(f"✗ ACK lost for packet: {current_ack}")
                            if(current_send > current_ack):
                                current_send = current_ack 
                            current_ack += 1
                    else:
                        break;
                current_ack = current_send
                print("\n")
            print(f"\n🕔 Total time taken: {time_elapsed} seconds") 


    def selective_repeat(self):
        next_seq_num = 0
        received_ack = set()
        data = ["pck1", "pck2", "pck3", "pck4", "pck5", "pck6", "pck7", "pck8", "pck9", "pck10", "pck11"]
        window_size = 5  # Adjust window size as needed

        def send_packet(seq_num):
            if seq_num < len(data):
                print(f"Sender: Sending packet {seq_num} --> {data[seq_num]}")

        while next_seq_num < len(data):
            ack_range_start = next_seq_num
            ack_range_end = min(next_seq_num + window_size, len(data))

            # Send packets within the window
            for i in range(next_seq_num, min(next_seq_num + window_size, len(data))):
                send_packet(i)

            # Simulate receiving acknowledgments for the entire window
            ack_received = [random.choice(['✓', '✗']) for _ in range(ack_range_start, ack_range_end)]
            print("\n")

            for i, ack in enumerate(ack_received):
                ack_status = "Received ✓" if ack == '✓' else "Lost ✗"
                print(f"Receiver: {ack_status} ACK for packet {ack_range_start + i}")

                if ack == '✓':
                    received_ack.add(ack_range_start + i)
            print("\n")


            # Check for missing ACKs and resend missing packets
            missing_packets = [i for i in range(ack_range_start, ack_range_end) if i not in received_ack]

            while missing_packets:
                for packet in missing_packets:
                    print(f"Sender: Resending packet {packet} --> {data[packet]}")

                # Simulate receiving acknowledgments for resent packets
                ack_received = [random.choice(['✓', '✗']) for _ in missing_packets]
                print("\n")


                for i, ack in enumerate(ack_received):
                    ack_status = "Received ✓" if ack == '✓' else "Lost ✗"
                    print(f"Receiver: {ack_status} ACK for resent packet {missing_packets[i]}")

                    if ack == '✓':
                        received_ack.add(missing_packets[i])

                # Check for missing ACKs after resending
                missing_packets = [i for i in missing_packets if i not in received_ack]
                print("\n")

            next_seq_num = ack_range_end



    def menu(self):
        
        while True:
            print("\nSelect a protocol:")
            print("1. Stop-and-Wait ARQ")
            print("2. Go-Back-N ARQ")
            print("3. Selective Repeat ARQ")
            print("4. Quit")
            choice = int(input("Enter your choice: "))
            
            if choice == 1:
                self.simulate_stop_and_wait()
            elif choice == 2:
                self.simulate_go_back_n()
            elif choice == 3:
                self.selective_repeat()
            elif choice == 4:
                break
            else:
                print("Invalid choice, please try again")

if __name__ == "__main__":
    packet_loss_prob = 0.2
    simulator = NoisyChannelSimulation(packet_loss_prob)
    simulator.menu()
