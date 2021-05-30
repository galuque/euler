P   := p1
ARG := 1000

SRC_DIR := src
OBJ_DIR := obj
BIN_DIR := bin

EXE := $(BIN_DIR)/p1

SRC := $(wildcard $(SRC_DIR)/*.c)
OBJ := $(SRC:$(SRC_DIR)/%.c=$(OBJ_DIR)/%.o)

TIME_CMD := /usr/bin/time -p

CPPFLAGS := -Iinclude -MMD -MP 
CFLAGS   := -g3 -Wall -O3 -std=c11 -Wpedantic -fsanitize=undefined
LDFLAGS  := -Wall -fsanitize=undefined
LDLIBS   := 
CC       := gcc

.PHONY: all clean run

all: $(EXE)

$(EXE): $(OBJ) | $(BIN_DIR)
	$(CC) $(LDFLAGS) $^ $(LDLIBS) -o $@

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(OBJ_DIR)
	$(CC) $(CPPFLAGS) $(CFLAGS) -c $< -o $@

$(BIN_DIR) $(OBJ_DIR):
	mkdir -p $@

clean:
	@$(RM) -rv $(BIN_DIR) $(OBJ_DIR)

run:
	$(TIME_CMD) ./$(EXE) $(ARG)

-include $(OBJ:.o=.d)
