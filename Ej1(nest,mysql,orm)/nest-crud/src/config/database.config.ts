import { ConfigService } from '@nestjs/config';
import { TypeOrmModuleOptions } from '@nestjs/typeorm';
import { join } from 'path';

export const databaseConfig = async (
  configService: ConfigService,
): Promise<TypeOrmModuleOptions> => {
    console.log(configService.get<string>('DB_SYNC') === 'true')
  return {
    type: 'mysql',
    host: configService.get<string>('DB_HOST'),
    port: configService.get<number>('DB_PORT'),
    username: configService.get<string>('DB_USERNAME'),
    password: configService.get<string>('DB_PASSWORD'),
    database: configService.get<string>('DB_NAME'),
    entities: [join(__dirname, '/../**/*.entity{.ts,.js}')],
    synchronize:configService.get<string>('DB_SYNC') === 'true',
    logging: configService.get<boolean>('DB_LOGGING', false),
  };
};
