// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;



public class ConwaysLife {

    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());


            screen.startScreen();
            screen.setCursorPosition(null);

            simulation.insertPattern(new PatternBlinker(), 0,0 );
            simulation.insertPattern(new PatternAcorn(), 5,5 );
            simulation.insertPattern(new PatternBlock(), 10,10 );
            simulation.insertPattern(new PatternGlider(), 15,15 );



            for (int i = 0; i < 50; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                //sampleRender(screen, graphics, i);

                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(200);                // Sleep for a bit to make for a nicer paced animation

                simulation.update();                    // Tell the simulation to update
            }
            Thread.sleep(1000);
            screen.stopScreen();


        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }

    private static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {
        screen.clear();
        for(int i = 0; i < simulation.sizeX; i++ ) {
            for(int j = 0; j < simulation.sizeY; j++) {
                if(simulation.getCell(j,i)) {
                    System.out.println("Printing at "+ j +" "+ i);
                    graphics.setCharacter(j, i, 'X');
                }
            }
        }
        try {
            screen.refresh();
        } catch (Exception ex) {
        }


    }

    public static void sampleRender(Screen screen, TextGraphics graphics, int xPos) {
        screen.clear();

        // Not very interesting, but showing how to set characters
        graphics.setCharacter(xPos, 10, 'K');
        graphics.setCharacter(xPos + 1, 10, 'I');
        graphics.setCharacter(xPos + 2, 10, 'S');
        graphics.setCharacter(xPos + 3, 10, 'S');
        graphics.setCharacter(xPos + 4, 10, ' ');
        graphics.setCharacter(xPos + 5, 10, 'M');
        graphics.setCharacter(xPos + 6, 10, 'Y');
        graphics.setCharacter(xPos + 7, 10, ' ');
        graphics.setCharacter(xPos + 8, 10, 'A');
        graphics.setCharacter(xPos + 9, 10, 'S');
        graphics.setCharacter(xPos + 10, 10, 'S');

        // This is what causes the console to render the new state, it is required
        try {
            screen.refresh();
        } catch (Exception ex) {
        }
    }
}
