package anticope.rejects.commands;

import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import java.util.ArrayList;

public class PanicCommand extends Command {
    public PanicCommand() {
        super("panic", "Disables all modules.", "disable-all");
    }

    @Override
    public void build(LiteralArgumentBuilder<ClientSuggestionProvider> builder) {
        builder.executes(context -> {
            new ArrayList<>(Modules.get().getActive()).forEach(Module::toggle);

            return SINGLE_SUCCESS;
        });
    }
}
