package com.uchuika.anniaddon.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ExampleCommand {

        LiteralArgumentBuilder<CommandSource> builder = Commands.literal("hoge")
                .executes(context -> {

                    return Command.SINGLE_SUCCESS;
                });

    }

