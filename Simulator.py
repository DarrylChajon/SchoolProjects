# Simulator.py is a small project that I created to translate between machine code and assembly language by defining the values of the registers.

import argparse
import re

registers = {
   "$zero": 0,
   "$at": 1,
   "$v0": 2,
   "$v1": 3,
   "$a0": 4,
   "$a1": 5,
   "$a2": 6,
   "$a3": 7,
   "$k0": 26,
   "$k1": 27,
   "$gp": 28,
   "$sp": 29, 
   "$fp": 30,
   "$ra": 31,
   "$t0": 8,
   "$t1": 9,
   "$t2": 10,
   "$t3": 11,
   "$t4": 12,
   "$t5": 13,
   "$t6": 14,
   "$t7": 15,
   "$s0": 16,
   "$s1": 17,
   "$s2": 18,
   "$s3": 19,
   "$s4": 20,
   "$s5": 21,
   "$s6": 22,
   "$s7": 23,
   "$t8": 24,
   "$t9": 25,
}

def assemble(instruction):
   parts = re.split(r'\s+|,\s*', instruction.strip())
   opcode = 0
   rs = 0
   rt = 0
   rd = 0
   shamt = 0
   funct = 0
   
   if parts[0] == "add":
      opcode = 0
      funct = 32
      rs = registers[parts[2]]
      rt = registers[parts[3]]
      rd = registers[parts[1]]
   
   machine_code = (opcode << 26) | (rs << 21) | (rt << 16) | (rd << 11) | (shamt << 6) | funct
   return format(machine_code, '08x')

def disassemble(machine_code):
   machine_code = int(machine_code, 16)
   opcode = (machine_code >> 26) & 0x3F
   rs = (machine_code >> 21) & 0x1F
   rt = (machine_code >> 16) & 0x1F
   rd = (machine_code >> 11) & 0x1F
   shamt = (machine_code >> 6) & 0x1F
   funct = machine_code & 0x3F
   
   if funct == 32:
      return f"add {list(registers.keys())[list(registers.values()).index(rd)]}, {list(registers.keys())[list(registers.values()).index(rs)]}, {list(registers.keys())[list(registers.values()).index(rt)]}"

def main():
   parser = argparse.ArgumentParser(description='MIPS Code Converter')
   parser.add_argument('-a', '--assemble', help='Convert assembly to machine code')
   parser.add_argument('-m', '--disassemble', help='Convert machine code to assembly')
   args = parser.parse_args()
   
   if args.assemble:
      print("Machine Code:", assemble(args.assemble))
   elif args.disassemble:
      print("Assembly Code:", disassemble(args.disassemble))
   else:
      print("Enter input")
if __name__ == '__main__':
   main()
